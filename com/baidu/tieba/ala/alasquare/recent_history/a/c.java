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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long fYK;
    private a fYL;
    private Drawable mLeftDrawable;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fYK = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.fYL = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.fYG = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.fYG.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.fYG.setIsRound(true);
            bVar.fYG.setAutoChangeStyle(false);
            bVar.fYG.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.dNo = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.fYI = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.fYJ = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.fYO = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.fYP = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.fYQ = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setViewTextColor(bVar.dNo, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.fYO, R.color.cp_cont_d);
            ap.setViewTextColor(bVar.fYP, R.color.cp_cont_e);
            ap.setViewTextColor(bVar.fYQ, R.color.square_follow_btn_txt_color);
            bVar.fYI.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.fYJ, R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b tx = getItem(i);
        if (tx != null && tx.eji != null && tx.eji.bih() != null) {
            final MetaData bih = tx.eji.bih();
            bVar.fYG.startLoad(bih.getPortrait(), 12, false);
            this.fYD = 0;
            bVar.fYI.setVisibility(8);
            bVar.fYJ.setVisibility(8);
            if (!y.isEmpty(tx.tagList)) {
                for (b.a aVar : tx.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aGH) {
                            bVar.fYI.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fYT)) {
                                bVar.fYI.setText(aVar.fYT);
                            }
                            this.fYD++;
                        } else if (2 == aVar.aGH) {
                            bVar.fYJ.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fYT)) {
                                bVar.fYJ.setText(aVar.fYT);
                            }
                            this.fYD++;
                        }
                    }
                }
            }
            boolean z = tx.isFollow;
            String name_show = bih.getName_show();
            if (this.fYD <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.dNo.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.fYO.setText(at.getFormatTimeShort(tx.fYS * 1000));
            a(z, bVar);
            bVar.fYQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.fYL != null) {
                        c.this.fYL.a(tx);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bL = c.this.bL(tx.tagList);
                    aq aqVar = new aq("c12661");
                    aqVar.dK("obj_id", tx.eji.bih().getUserId());
                    aqVar.aj("obj_type", bL ? 1 : 0);
                    TiebaStatic.log(aqVar);
                    if (!c.this.bL(tx.tagList)) {
                        c.this.d(bih);
                    } else {
                        c.this.a(c.this.mPageContext, tx.eji, "recent_history_whole_tab");
                    }
                }
            });
            aq aqVar = new aq("c12660");
            aqVar.dK("obj_id", tx.eji.bih().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bKA().e(aqVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bL(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aGH) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.fYQ.setVisibility(8);
            bVar.fYP.setVisibility(0);
            bVar.fYP.setEnabled(false);
            return;
        }
        bVar.fYP.setVisibility(8);
        bVar.fYQ.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.fYK).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b {
        public TextView dNo;
        public TbImageView fYG;
        public TextView fYI;
        public TextView fYJ;
        public TextView fYO;
        public TextView fYP;
        public TextView fYQ;

        private b() {
        }
    }
}
