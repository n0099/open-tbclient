package com.baidu.tieba.ala.alasquare.recent_history.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long goj;
    private a gok;
    private Drawable mLeftDrawable;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.goj = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.gok = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.gof = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.gof.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.gof.setIsRound(true);
            bVar.gof.setAutoChangeStyle(false);
            bVar.gof.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.dZV = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.goh = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.goi = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.gon = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.goo = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.gop = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setViewTextColor(bVar.dZV, R.color.CAM_X0105);
            ap.setViewTextColor(bVar.gon, R.color.CAM_X0109);
            ap.setViewTextColor(bVar.goo, R.color.CAM_X0110);
            ap.setViewTextColor(bVar.gop, R.color.square_follow_btn_txt_color);
            bVar.goh.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.goi, R.color.CAM_X0301);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b uy = getItem(i);
        if (uy != null && uy.evQ != null && uy.evQ.blC() != null) {
            final MetaData blC = uy.evQ.blC();
            bVar.gof.startLoad(blC.getPortrait(), 12, false);
            this.goc = 0;
            bVar.goh.setVisibility(8);
            bVar.goi.setVisibility(8);
            if (!y.isEmpty(uy.tagList)) {
                for (b.a aVar : uy.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aFU) {
                            bVar.goh.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gos)) {
                                bVar.goh.setText(aVar.gos);
                            }
                            this.goc++;
                        } else if (2 == aVar.aFU) {
                            bVar.goi.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gos)) {
                                bVar.goi.setText(aVar.gos);
                            }
                            this.goc++;
                        }
                    }
                }
            }
            boolean z = uy.isFollow;
            String name_show = blC.getName_show();
            if (this.goc <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.dZV.setText(k.byteLength(name_show) > i2 ? au.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.gon.setText(au.getFormatTimeShort(uy.gor * 1000));
            a(z, bVar);
            bVar.gop.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gok != null) {
                        c.this.gok.a(uy);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean cc = c.this.cc(uy.tagList);
                    ar arVar = new ar("c12661");
                    arVar.dR("obj_id", uy.evQ.blC().getUserId());
                    arVar.ak("obj_type", cc ? 1 : 0);
                    TiebaStatic.log(arVar);
                    if (!c.this.cc(uy.tagList)) {
                        c.this.d(blC);
                    } else {
                        c.this.a(c.this.mPageContext, uy.evQ, "recent_history_whole_tab");
                    }
                }
            });
            ar arVar = new ar("c12660");
            arVar.dR("obj_id", uy.evQ.blC().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bOV().e(arVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cc(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aFU) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.gop.setVisibility(8);
            bVar.goo.setVisibility(0);
            bVar.goo.setEnabled(false);
            return;
        }
        bVar.goo.setVisibility(8);
        bVar.gop.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.goj).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b {
        public TextView dZV;
        public TbImageView gof;
        public TextView goh;
        public TextView goi;
        public TextView gon;
        public TextView goo;
        public TextView gop;

        private b() {
        }
    }
}
