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
    private long fMt;
    private a fMu;
    private Drawable mLeftDrawable;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fMt = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = ap.getDrawable(this.mContext.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.fMu = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.fMp = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.fMp.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.fMp.setIsRound(true);
            bVar.fMp.setAutoChangeStyle(false);
            bVar.fMp.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.dBn = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.fMr = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.fMs = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.fMx = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.fMy = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.fMz = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setViewTextColor(bVar.dBn, R.color.cp_cont_b);
            ap.setViewTextColor(bVar.fMx, R.color.cp_cont_d);
            ap.setViewTextColor(bVar.fMy, R.color.cp_cont_e);
            ap.setViewTextColor(bVar.fMz, R.color.square_follow_btn_txt_color);
            bVar.fMr.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.fMs, R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b sZ = getItem(i);
        if (sZ != null && sZ.dXg != null && sZ.dXg.bfy() != null) {
            final MetaData bfy = sZ.dXg.bfy();
            bVar.fMp.startLoad(bfy.getPortrait(), 12, false);
            this.fMm = 0;
            bVar.fMr.setVisibility(8);
            bVar.fMs.setVisibility(8);
            if (!y.isEmpty(sZ.tagList)) {
                for (b.a aVar : sZ.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aDD) {
                            bVar.fMr.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fMC)) {
                                bVar.fMr.setText(aVar.fMC);
                            }
                            this.fMm++;
                        } else if (2 == aVar.aDD) {
                            bVar.fMs.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fMC)) {
                                bVar.fMs.setText(aVar.fMC);
                            }
                            this.fMm++;
                        }
                    }
                }
            }
            boolean z = sZ.isFollow;
            String name_show = bfy.getName_show();
            if (this.fMm <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.dBn.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.fMx.setText(at.getFormatTimeShort(sZ.fMB * 1000));
            a(z, bVar);
            bVar.fMz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.fMu != null) {
                        c.this.fMu.a(sZ);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bI = c.this.bI(sZ.tagList);
                    aq aqVar = new aq("c12661");
                    aqVar.dF("obj_id", sZ.dXg.bfy().getUserId());
                    aqVar.ai("obj_type", bI ? 1 : 0);
                    TiebaStatic.log(aqVar);
                    if (!c.this.bI(sZ.tagList)) {
                        c.this.d(bfy);
                    } else {
                        c.this.a(c.this.mPageContext, sZ.dXg, "recent_history_whole_tab");
                    }
                }
            });
            aq aqVar = new aq("c12660");
            aqVar.dF("obj_id", sZ.dXg.bfy().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bHO().e(aqVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bI(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aDD) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.fMz.setVisibility(8);
            bVar.fMy.setVisibility(0);
            bVar.fMy.setEnabled(false);
            return;
        }
        bVar.fMy.setVisibility(8);
        bVar.fMz.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.fMt).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b {
        public TextView dBn;
        public TbImageView fMp;
        public TextView fMr;
        public TextView fMs;
        public TextView fMx;
        public TextView fMy;
        public TextView fMz;

        private b() {
        }
    }
}
