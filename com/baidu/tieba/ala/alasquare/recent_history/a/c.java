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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long fhb;
    private a fhc;
    private Drawable mLeftDrawable;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fhb = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.fhc = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.fgX = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.fgX.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.fgX.setIsRound(true);
            bVar.fgX.setAutoChangeStyle(false);
            bVar.fgX.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.dez = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.fgZ = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.fha = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.fhf = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.fhg = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.fhh = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.dez, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.fhf, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.fhg, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.fhh, (int) R.color.square_follow_btn_txt_color);
            bVar.fgZ.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.fha, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b pF = getItem(i);
        if (pF != null && pF.dEA != null && pF.dEA.aQx() != null) {
            final MetaData aQx = pF.dEA.aQx();
            bVar.fgX.startLoad(aQx.getPortrait(), 12, false);
            this.fgU = 0;
            bVar.fgZ.setVisibility(8);
            bVar.fha.setVisibility(8);
            if (!v.isEmpty(pF.tagList)) {
                for (b.a aVar : pF.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.auw) {
                            bVar.fgZ.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fhk)) {
                                bVar.fgZ.setText(aVar.fhk);
                            }
                            this.fgU++;
                        } else if (2 == aVar.auw) {
                            bVar.fha.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fhk)) {
                                bVar.fha.setText(aVar.fhk);
                            }
                            this.fgU++;
                        }
                    }
                }
            }
            boolean z = pF.isFollow;
            String name_show = aQx.getName_show();
            if (this.fgU <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.dez.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.fhf.setText(aq.getFormatTimeShort(pF.fhj * 1000));
            a(z, bVar);
            bVar.fhh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.fhc != null) {
                        c.this.fhc.a(pF);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bp = c.this.bp(pF.tagList);
                    an anVar = new an("c12661");
                    anVar.dh("obj_id", pF.dEA.aQx().getUserId());
                    anVar.ag("obj_type", bp ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bp(pF.tagList)) {
                        c.this.d(aQx);
                    } else {
                        c.this.a(c.this.mPageContext, pF.dEA, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.dh("obj_id", pF.dEA.aQx().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.brq().e(anVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bp(List<b.a> list) {
        if (!v.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.auw) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.fhh.setVisibility(8);
            bVar.fhg.setVisibility(0);
            bVar.fhg.setEnabled(false);
            return;
        }
        bVar.fhg.setVisibility(8);
        bVar.fhh.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.fhb).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        public TextView dez;
        public TbImageView fgX;
        public TextView fgZ;
        public TextView fha;
        public TextView fhf;
        public TextView fhg;
        public TextView fhh;

        private b() {
        }
    }
}
