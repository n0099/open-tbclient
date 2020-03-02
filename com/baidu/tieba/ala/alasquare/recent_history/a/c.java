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
    private long eqi;
    private a eqj;
    private Drawable mLeftDrawable;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eqi = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.eqj = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.eqe = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.eqe.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.eqe.setIsRound(true);
            bVar.eqe.setAutoChangeStyle(false);
            bVar.eqe.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.cuh = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.eqg = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.eqh = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.eqm = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.eqn = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.eqo = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.cuh, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.eqm, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.eqn, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.eqo, (int) R.color.square_follow_btn_txt_color);
            bVar.eqg.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.eqh, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b oJ = getItem(i);
        if (oJ != null && oJ.cRf != null && oJ.cRf.aCo() != null) {
            final MetaData aCo = oJ.cRf.aCo();
            bVar.eqe.startLoad(aCo.getPortrait(), 12, false);
            this.eqb = 0;
            bVar.eqg.setVisibility(8);
            bVar.eqh.setVisibility(8);
            if (!v.isEmpty(oJ.tagList)) {
                for (b.a aVar : oJ.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.Xk) {
                            bVar.eqg.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.eqr)) {
                                bVar.eqg.setText(aVar.eqr);
                            }
                            this.eqb++;
                        } else if (2 == aVar.Xk) {
                            bVar.eqh.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.eqr)) {
                                bVar.eqh.setText(aVar.eqr);
                            }
                            this.eqb++;
                        }
                    }
                }
            }
            boolean z = oJ.isFollow;
            String name_show = aCo.getName_show();
            if (this.eqb <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.cuh.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.eqm.setText(aq.getFormatTimeShort(oJ.eqq * 1000));
            a(z, bVar);
            bVar.eqo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.eqj != null) {
                        c.this.eqj.a(oJ);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bk = c.this.bk(oJ.tagList);
                    an anVar = new an("c12661");
                    anVar.cy("obj_id", oJ.cRf.aCo().getUserId());
                    anVar.X("obj_type", bk ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bk(oJ.tagList)) {
                        c.this.d(aCo);
                    } else {
                        c.this.a(c.this.mPageContext, oJ.cRf, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.cy("obj_id", oJ.cRf.aCo().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bcX().d(anVar);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bk(List<b.a> list) {
        if (!v.isEmpty(list)) {
            for (b.a aVar : list) {
                if (aVar != null && 1 == aVar.Xk) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(boolean z, b bVar) {
        if (z) {
            bVar.eqo.setVisibility(8);
            bVar.eqn.setVisibility(0);
            bVar.eqn.setEnabled(false);
            return;
        }
        bVar.eqn.setVisibility(8);
        bVar.eqo.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.eqi).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        public TextView cuh;
        public TbImageView eqe;
        public TextView eqg;
        public TextView eqh;
        public TextView eqm;
        public TextView eqn;
        public TextView eqo;

        private b() {
        }
    }
}
