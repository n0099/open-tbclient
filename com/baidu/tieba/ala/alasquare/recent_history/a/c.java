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
    private long fJa;
    private a fJb;
    private Drawable mLeftDrawable;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJa = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = ap.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.fJb = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.fIW = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.fIW.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.fIW.setIsRound(true);
            bVar.fIW.setAutoChangeStyle(false);
            bVar.fIW.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.dzi = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.fIY = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.fIZ = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.fJe = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.fJf = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.fJg = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setViewTextColor(bVar.dzi, (int) R.color.cp_cont_b);
            ap.setViewTextColor(bVar.fJe, (int) R.color.cp_cont_d);
            ap.setViewTextColor(bVar.fJf, (int) R.color.cp_cont_e);
            ap.setViewTextColor(bVar.fJg, (int) R.color.square_follow_btn_txt_color);
            bVar.fIY.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(bVar.fIZ, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b sH = getItem(i);
        if (sH != null && sH.dUS != null && sH.dUS.beE() != null) {
            final MetaData beE = sH.dUS.beE();
            bVar.fIW.startLoad(beE.getPortrait(), 12, false);
            this.fIT = 0;
            bVar.fIY.setVisibility(8);
            bVar.fIZ.setVisibility(8);
            if (!y.isEmpty(sH.tagList)) {
                for (b.a aVar : sH.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.aCR) {
                            bVar.fIY.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fJj)) {
                                bVar.fIY.setText(aVar.fJj);
                            }
                            this.fIT++;
                        } else if (2 == aVar.aCR) {
                            bVar.fIZ.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fJj)) {
                                bVar.fIZ.setText(aVar.fJj);
                            }
                            this.fIT++;
                        }
                    }
                }
            }
            boolean z = sH.isFollow;
            String name_show = beE.getName_show();
            if (this.fIT <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.dzi.setText(k.byteLength(name_show) > i2 ? at.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.fJe.setText(at.getFormatTimeShort(sH.fJi * 1000));
            a(z, bVar);
            bVar.fJg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.fJb != null) {
                        c.this.fJb.a(sH);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bD = c.this.bD(sH.tagList);
                    aq aqVar = new aq("c12661");
                    aqVar.dD("obj_id", sH.dUS.beE().getUserId());
                    aqVar.ai("obj_type", bD ? 1 : 0);
                    TiebaStatic.log(aqVar);
                    if (!c.this.bD(sH.tagList)) {
                        c.this.d(beE);
                    } else {
                        c.this.a(c.this.mPageContext, sH.dUS, "recent_history_whole_tab");
                    }
                }
            });
            aq aqVar = new aq("c12660");
            aqVar.dD("obj_id", sH.dUS.beE().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bGx().e(aqVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bD(List<b.a> list) {
        if (!y.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.aCR) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.fJg.setVisibility(8);
            bVar.fJf.setVisibility(0);
            bVar.fJf.setEnabled(false);
            return;
        }
        bVar.fJf.setVisibility(8);
        bVar.fJg.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.fJa).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b {
        public TextView dzi;
        public TbImageView fIW;
        public TextView fIY;
        public TextView fIZ;
        public TextView fJe;
        public TextView fJf;
        public TextView fJg;

        private b() {
        }
    }
}
