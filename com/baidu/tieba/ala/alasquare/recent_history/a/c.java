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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.recent_history.b.b;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.ala.alasquare.recent_history.a.a {
    private long fsA;
    private a fsB;
    private Drawable mLeftDrawable;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fsA = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = an.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.fsB = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.fsw = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.fsw.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.fsw.setIsRound(true);
            bVar.fsw.setAutoChangeStyle(false);
            bVar.fsw.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.djl = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.fsy = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.fsz = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.fsE = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.fsF = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.fsG = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            an.setBackgroundColor(view, R.color.cp_bg_line_d);
            an.setViewTextColor(bVar.djl, (int) R.color.cp_cont_b);
            an.setViewTextColor(bVar.fsE, (int) R.color.cp_cont_d);
            an.setViewTextColor(bVar.fsF, (int) R.color.cp_cont_e);
            an.setViewTextColor(bVar.fsG, (int) R.color.square_follow_btn_txt_color);
            bVar.fsy.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            an.setViewTextColor(bVar.fsz, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b qg = getItem(i);
        if (qg != null && qg.dLi != null && qg.dLi.aSp() != null) {
            final MetaData aSp = qg.dLi.aSp();
            bVar.fsw.startLoad(aSp.getPortrait(), 12, false);
            this.fst = 0;
            bVar.fsy.setVisibility(8);
            bVar.fsz.setVisibility(8);
            if (!w.isEmpty(qg.tagList)) {
                for (b.a aVar : qg.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.awC) {
                            bVar.fsy.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fsJ)) {
                                bVar.fsy.setText(aVar.fsJ);
                            }
                            this.fst++;
                        } else if (2 == aVar.awC) {
                            bVar.fsz.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.fsJ)) {
                                bVar.fsz.setText(aVar.fsJ);
                            }
                            this.fst++;
                        }
                    }
                }
            }
            boolean z = qg.isFollow;
            String name_show = aSp.getName_show();
            if (this.fst <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.djl.setText(k.byteLength(name_show) > i2 ? ar.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.fsE.setText(ar.getFormatTimeShort(qg.fsI * 1000));
            a(z, bVar);
            bVar.fsG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.fsB != null) {
                        c.this.fsB.a(qg);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean by = c.this.by(qg.tagList);
                    ao aoVar = new ao("c12661");
                    aoVar.dk("obj_id", qg.dLi.aSp().getUserId());
                    aoVar.ag("obj_type", by ? 1 : 0);
                    TiebaStatic.log(aoVar);
                    if (!c.this.by(qg.tagList)) {
                        c.this.d(aSp);
                    } else {
                        c.this.a(c.this.mPageContext, qg.dLi, "recent_history_whole_tab");
                    }
                }
            });
            ao aoVar = new ao("c12660");
            aoVar.dk("obj_id", qg.dLi.aSp().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bup().e(aoVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean by(List<b.a> list) {
        if (!w.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.awC) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.fsG.setVisibility(8);
            bVar.fsF.setVisibility(0);
            bVar.fsF.setEnabled(false);
            return;
        }
        bVar.fsF.setVisibility(8);
        bVar.fsG.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.fsA).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        public TextView djl;
        public TextView fsE;
        public TextView fsF;
        public TextView fsG;
        public TbImageView fsw;
        public TextView fsy;
        public TextView fsz;

        private b() {
        }
    }
}
