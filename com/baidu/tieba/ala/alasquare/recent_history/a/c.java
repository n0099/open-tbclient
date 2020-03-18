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
    private long eqR;
    private a eqS;
    private Drawable mLeftDrawable;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eqR = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.eqS = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.eqN = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.eqN.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.eqN.setIsRound(true);
            bVar.eqN.setAutoChangeStyle(false);
            bVar.eqN.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.cuv = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.eqP = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.eqQ = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.eqV = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.eqW = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.eqX = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.cuv, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.eqV, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.eqW, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.eqX, (int) R.color.square_follow_btn_txt_color);
            bVar.eqP.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.eqQ, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b oL = getItem(i);
        if (oL != null && oL.cRt != null && oL.cRt.aCr() != null) {
            final MetaData aCr = oL.cRt.aCr();
            bVar.eqN.startLoad(aCr.getPortrait(), 12, false);
            this.eqK = 0;
            bVar.eqP.setVisibility(8);
            bVar.eqQ.setVisibility(8);
            if (!v.isEmpty(oL.tagList)) {
                for (b.a aVar : oL.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.Xu) {
                            bVar.eqP.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.era)) {
                                bVar.eqP.setText(aVar.era);
                            }
                            this.eqK++;
                        } else if (2 == aVar.Xu) {
                            bVar.eqQ.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.era)) {
                                bVar.eqQ.setText(aVar.era);
                            }
                            this.eqK++;
                        }
                    }
                }
            }
            boolean z = oL.isFollow;
            String name_show = aCr.getName_show();
            if (this.eqK <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.cuv.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.eqV.setText(aq.getFormatTimeShort(oL.eqZ * 1000));
            a(z, bVar);
            bVar.eqX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.eqS != null) {
                        c.this.eqS.a(oL);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bk = c.this.bk(oL.tagList);
                    an anVar = new an("c12661");
                    anVar.cx("obj_id", oL.cRt.aCr().getUserId());
                    anVar.X("obj_type", bk ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bk(oL.tagList)) {
                        c.this.d(aCr);
                    } else {
                        c.this.a(c.this.mPageContext, oL.cRt, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.cx("obj_id", oL.cRt.aCr().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bdd().e(anVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bk(List<b.a> list) {
        if (!v.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.Xu) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.eqX.setVisibility(8);
            bVar.eqW.setVisibility(0);
            bVar.eqW.setEnabled(false);
            return;
        }
        bVar.eqW.setVisibility(8);
        bVar.eqX.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.eqR).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        public TextView cuv;
        public TbImageView eqN;
        public TextView eqP;
        public TextView eqQ;
        public TextView eqV;
        public TextView eqW;
        public TextView eqX;

        private b() {
        }
    }
}
