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
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long gwu;
    private a gwv;
    private Drawable mLeftDrawable;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gwu = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.gwv = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.gwq = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.gwq.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.gwq.setIsRound(true);
            bVar.gwq.setAutoChangeStyle(false);
            bVar.gwq.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.egV = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.gws = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.gwt = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.gwy = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.gwz = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.gwA = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setViewTextColor(bVar.egV, (int) R.color.CAM_X0105);
            ap.setViewTextColor(bVar.gwy, (int) R.color.CAM_X0109);
            ap.setViewTextColor(bVar.gwz, (int) R.color.CAM_X0110);
            ap.setViewTextColor(bVar.gwA, (int) R.color.square_follow_btn_txt_color);
            bVar.gws.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.gwt, (int) R.color.CAM_X0301);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b vc = getItem(i);
        if (vc != null && vc.eCR != null && vc.eCR.boP() != null) {
            final MetaData boP = vc.eCR.boP();
            bVar.gwq.startLoad(boP.getPortrait(), 12, false);
            this.gwn = 0;
            bVar.gws.setVisibility(8);
            bVar.gwt.setVisibility(8);
            if (!y.isEmpty(vc.tagList)) {
                for (b.a aVar : vc.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aIC) {
                            bVar.gws.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gwD)) {
                                bVar.gws.setText(aVar.gwD);
                            }
                            this.gwn++;
                        } else if (2 == aVar.aIC) {
                            bVar.gwt.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.gwD)) {
                                bVar.gwt.setText(aVar.gwD);
                            }
                            this.gwn++;
                        }
                    }
                }
            }
            boolean z = vc.isFollow;
            String name_show = boP.getName_show();
            if (this.gwn <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.egV.setText(k.byteLength(name_show) > i2 ? au.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.gwy.setText(au.getFormatTimeShort(vc.gwC * 1000));
            a(z, bVar);
            bVar.gwA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.gwv != null) {
                        c.this.gwv.a(vc);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean cg = c.this.cg(vc.tagList);
                    ar arVar = new ar("c12661");
                    arVar.dY("obj_id", vc.eCR.boP().getUserId());
                    arVar.al("obj_type", cg ? 1 : 0);
                    TiebaStatic.log(arVar);
                    if (!c.this.cg(vc.tagList)) {
                        c.this.d(boP);
                    } else {
                        c.this.a(c.this.mPageContext, vc.eCR, "recent_history_whole_tab");
                    }
                }
            });
            ar arVar = new ar("c12660");
            arVar.dY("obj_id", vc.eCR.boP().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bSH().e(arVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cg(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aIC) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.gwA.setVisibility(8);
            bVar.gwz.setVisibility(0);
            bVar.gwz.setEnabled(false);
            return;
        }
        bVar.gwz.setVisibility(8);
        bVar.gwA.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.gwu).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b {
        public TextView egV;
        public TextView gwA;
        public TbImageView gwq;
        public TextView gws;
        public TextView gwt;
        public TextView gwy;
        public TextView gwz;

        private b() {
        }
    }
}
