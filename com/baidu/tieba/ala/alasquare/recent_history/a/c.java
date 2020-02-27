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
    private long eqh;
    private a eqi;
    private Drawable mLeftDrawable;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.alasquare.recent_history.b.b bVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eqh = com.baidu.adp.lib.f.b.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.mLeftDrawable = am.getDrawable(this.mContext.getResources(), (int) R.drawable.icon_video_direct_seeding);
    }

    public void a(a aVar) {
        this.eqi = aVar;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int i2;
        if (view == null) {
            bVar = new b();
            view = LayoutInflater.from(this.mContext).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            bVar.eqd = (TbImageView) view.findViewById(R.id.recent_history_whole_img);
            bVar.eqd.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            bVar.eqd.setIsRound(true);
            bVar.eqd.setAutoChangeStyle(false);
            bVar.eqd.setScaleType(ImageView.ScaleType.CENTER_CROP);
            bVar.cug = (TextView) view.findViewById(R.id.recent_history_whole_user_name);
            bVar.eqf = (TextView) view.findViewById(R.id.recent_history_whole_living_tag);
            bVar.eqg = (TextView) view.findViewById(R.id.recent_history_whole_send_gift_tag);
            bVar.eql = (TextView) view.findViewById(R.id.recent_history_whole_live_begin_time);
            bVar.eqm = (TextView) view.findViewById(R.id.recent_history_whole_follow_btn);
            bVar.eqn = (TextView) view.findViewById(R.id.recent_history_whole_unfollow_btn);
            am.setBackgroundColor(view, R.color.cp_bg_line_d);
            am.setViewTextColor(bVar.cug, (int) R.color.cp_cont_b);
            am.setViewTextColor(bVar.eql, (int) R.color.cp_cont_d);
            am.setViewTextColor(bVar.eqm, (int) R.color.cp_cont_e);
            am.setViewTextColor(bVar.eqn, (int) R.color.square_follow_btn_txt_color);
            bVar.eqf.setCompoundDrawablesWithIntrinsicBounds(this.mLeftDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(bVar.eqg, (int) R.color.cp_cont_h);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        final com.baidu.tieba.ala.alasquare.recent_history.b.b oJ = getItem(i);
        if (oJ != null && oJ.cRe != null && oJ.cRe.aCm() != null) {
            final MetaData aCm = oJ.cRe.aCm();
            bVar.eqd.startLoad(aCm.getPortrait(), 12, false);
            this.eqa = 0;
            bVar.eqf.setVisibility(8);
            bVar.eqg.setVisibility(8);
            if (!v.isEmpty(oJ.tagList)) {
                for (b.a aVar : oJ.tagList) {
                    if (aVar != null) {
                        if (1 == aVar.Xk) {
                            bVar.eqf.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.eqq)) {
                                bVar.eqf.setText(aVar.eqq);
                            }
                            this.eqa++;
                        } else if (2 == aVar.Xk) {
                            bVar.eqg.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.eqq)) {
                                bVar.eqg.setText(aVar.eqq);
                            }
                            this.eqa++;
                        }
                    }
                }
            }
            boolean z = oJ.isFollow;
            String name_show = aCm.getName_show();
            if (this.eqa <= 1) {
                i2 = 14;
            } else {
                i2 = z ? 12 : 10;
            }
            bVar.cug.setText(k.byteLength(name_show) > i2 ? aq.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE) : name_show);
            bVar.eql.setText(aq.getFormatTimeShort(oJ.eqp * 1000));
            a(z, bVar);
            bVar.eqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (c.this.eqi != null) {
                        c.this.eqi.a(oJ);
                    }
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.recent_history.a.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    boolean bk = c.this.bk(oJ.tagList);
                    an anVar = new an("c12661");
                    anVar.cy("obj_id", oJ.cRe.aCm().getUserId());
                    anVar.X("obj_type", bk ? 1 : 0);
                    TiebaStatic.log(anVar);
                    if (!c.this.bk(oJ.tagList)) {
                        c.this.d(aCm);
                    } else {
                        c.this.a(c.this.mPageContext, oJ.cRe, "recent_history_whole_tab");
                    }
                }
            });
            an anVar = new an("c12660");
            anVar.cy("obj_id", oJ.cRe.aCm().getUserId());
            com.baidu.tieba.ala.alasquare.c.a.bcV().d(anVar);
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
            bVar.eqn.setVisibility(8);
            bVar.eqm.setVisibility(0);
            bVar.eqm.setEnabled(false);
            return;
        }
        bVar.eqm.setVisibility(8);
        bVar.eqn.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tbadk.data.MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mContext).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.eqh).equals(metaData.getUserId()), metaData.isBigV())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b {
        public TextView cug;
        public TbImageView eqd;
        public TextView eqf;
        public TextView eqg;
        public TextView eql;
        public TextView eqm;
        public TextView eqn;

        private b() {
        }
    }
}
