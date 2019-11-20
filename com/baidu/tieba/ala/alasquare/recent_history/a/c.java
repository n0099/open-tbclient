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
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long dzX;
    private a dzY;
    private Drawable dzZ;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dzX = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.dzZ = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.dzY = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.dzT = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.dzT.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.dzT.setIsRound(true);
            bVar.dzT.setAutoChangeStyle(false);
            bVar.dzT.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.bFm = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.dzV = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.dzW = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.dAc = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.dAd = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.dAe = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.bFm, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.dAc, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.dAd, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.dAe, (int) R.color.square_follow_btn_txt_color);
            bVar.dzV.setCompoundDrawablesWithIntrinsicBounds(this.dzZ, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.dzW, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b mi = getItem(i);
        if (mi != null && mi.caz != null && mi.caz.aiE() != null) {
            final MetaData aiE = mi.caz.aiE();
            bVar.dzT.startLoad(aiE.getPortrait(), 12, false);
            this.dzQ = 0;
            bVar.dzV.setVisibility(8);
            bVar.dzW.setVisibility(8);
            if (!v.isEmpty(mi.tagList)) {
                for (b.a aVar : mi.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.Oo) {
                            bVar.dzV.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.dAh)) {
                                bVar.dzV.setText(aVar.dAh);
                            }
                            this.dzQ++;
                        } else if (2 == aVar.Oo) {
                            bVar.dzW.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.dAh)) {
                                bVar.dzW.setText(aVar.dAh);
                            }
                            this.dzQ++;
                        }
                    }
                }
            }
            boolean z = mi.isFollow;
            String name_show = aiE.getName_show();
            if (this.dzQ <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.bFm.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.dAc.setText(aq.getFormatTimeShort(mi.dAg * 1000));
            a(z, bVar);
            bVar.dAe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dzY != null) {
                        c.this.dzY.a(mi);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bl = c.this.bl(mi.tagList);
                    an anVar = new an("c12661");
                    anVar.bS("obj_id", mi.caz.aiE().getUserId());
                    anVar.O("obj_type", bl ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bl(mi.tagList)) {
                        c.this.d(aiE);
                    } else {
                        c.this.a(c.this.mPageContext, mi.caz, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.bS("obj_id", mi.caz.aiE().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.aJM().c(anVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bl(List<b.a> list) {
        if (!v.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.Oo) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.dAe.setVisibility(8);
            bVar.dAd.setVisibility(0);
            bVar.dAd.setEnabled(false);
            return;
        }
        bVar.dAd.setVisibility(8);
        bVar.dAe.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.dzX).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b {
        public TextView bFm;
        public TextView dAc;
        public TextView dAd;
        public TextView dAe;
        public TbImageView dzT;
        public TextView dzV;
        public TextView dzW;

        private b() {
        }
    }
}
