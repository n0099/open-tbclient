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
    private long dAO;
    private a dAP;
    private Drawable dAQ;

    /* loaded from: classes6.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.dAO = com.baidu.adp.lib.g.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.dAQ = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.dAP = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.dAK = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.dAK.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.dAK.setIsRound(true);
            bVar.dAK.setAutoChangeStyle(false);
            bVar.dAK.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.bGd = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.dAM = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.dAN = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.dAT = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.dAU = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.dAV = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.bGd, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.dAT, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.dAU, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.dAV, (int) R.color.square_follow_btn_txt_color);
            bVar.dAM.setCompoundDrawablesWithIntrinsicBounds(this.dAQ, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.dAN, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b mj = getItem(i);
        if (mj != null && mj.cbq != null && mj.cbq.aiG() != null) {
            final MetaData aiG = mj.cbq.aiG();
            bVar.dAK.startLoad(aiG.getPortrait(), 12, false);
            this.dAH = 0;
            bVar.dAM.setVisibility(8);
            bVar.dAN.setVisibility(8);
            if (!v.isEmpty(mj.tagList)) {
                for (b.a aVar : mj.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.OQ) {
                            bVar.dAM.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.dAY)) {
                                bVar.dAM.setText(aVar.dAY);
                            }
                            this.dAH++;
                        } else if (2 == aVar.OQ) {
                            bVar.dAN.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.dAY)) {
                                bVar.dAN.setText(aVar.dAY);
                            }
                            this.dAH++;
                        }
                    }
                }
            }
            boolean z = mj.isFollow;
            String name_show = aiG.getName_show();
            if (this.dAH <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.bGd.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.dAT.setText(aq.getFormatTimeShort(mj.dAX * 1000));
            a(z, bVar);
            bVar.dAV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.dAP != null) {
                        c.this.dAP.a(mj);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bl = c.this.bl(mj.tagList);
                    an anVar = new an("c12661");
                    anVar.bS("obj_id", mj.cbq.aiG().getUserId());
                    anVar.O("obj_type", bl ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bl(mj.tagList)) {
                        c.this.d(aiG);
                    } else {
                        c.this.a(c.this.mPageContext, mj.cbq, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.bS("obj_id", mj.cbq.aiG().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.aJO().c(anVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bl(List<b.a> list) {
        if (!v.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.OQ) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.dAV.setVisibility(8);
            bVar.dAU.setVisibility(0);
            bVar.dAU.setEnabled(false);
            return;
        }
        bVar.dAU.setVisibility(8);
        bVar.dAV.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.dAO).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b {
        public TextView bGd;
        public TbImageView dAK;
        public TextView dAM;
        public TextView dAN;
        public TextView dAT;
        public TextView dAU;
        public TextView dAV;

        private b() {
        }
    }
}
