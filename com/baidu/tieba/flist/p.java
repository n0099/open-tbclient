package com.baidu.tieba.flist;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.aj;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.model.ag;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private ag avA;
    private int awc;
    private BaseActivity mActivity;
    public int awb = -1;
    private int Af = 0;
    private boolean avG = true;
    private ForumDetailActivity.FromType awd = ForumDetailActivity.FromType.BAR_DIR;
    private boolean ly = false;
    private ForumInfoData[] awe = new ForumInfoData[0];

    public p(BaseActivity baseActivity, int i) {
        this.awc = 0;
        this.mActivity = baseActivity;
        this.awc = i;
    }

    public ForumInfoData[] DR() {
        return this.awe;
    }

    public void a(ForumDetailActivity.FromType fromType) {
        this.awd = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.awe = forumInfoDataArr;
        if (this.awe != null) {
            notifyDataSetChanged();
        }
    }

    public void a(ag agVar) {
        this.avA = agVar;
    }

    public void H(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void DS() {
        for (int i = 0; i < this.Af; i++) {
            int dV = aj.wm().dV(this.awe[i].forum_name);
            if (dV == 1) {
                this.awe[i].is_like = 1;
            } else if (dV == -1) {
                this.awe[i].is_like = 0;
            }
        }
    }

    public boolean DT() {
        if (this.avA == null) {
            return false;
        }
        return this.avA.TJ();
    }

    public void eA(int i) {
        this.Af = i;
        notifyDataSetChanged();
    }

    public void e(Boolean bool) {
        this.avG = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.awe == null) {
            return 0;
        }
        return this.Af <= this.awe.length ? this.Af : this.awe.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.Af) {
            return null;
        }
        return this.awe[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.mActivity, com.baidu.tieba.w.forum_list_forum_item, null);
            q qVar = new q(this);
            qVar.awf = (BarImageView) view.findViewById(com.baidu.tieba.v.forum_avatar);
            qVar.awf.setGifIconSupport(false);
            qVar.awi = (TextView) view.findViewById(com.baidu.tieba.v.name);
            qVar.awj = (TextView) view.findViewById(com.baidu.tieba.v.member_count);
            qVar.awk = (TextView) view.findViewById(com.baidu.tieba.v.thread_count);
            qVar.awl = (TextView) view.findViewById(com.baidu.tieba.v.slogan);
            qVar.awm = (TextView) view.findViewById(com.baidu.tieba.v.like);
            qVar.awg = (TextView) view.findViewById(com.baidu.tieba.v.rank_badge);
            qVar.awh = (TextView) view.findViewById(com.baidu.tieba.v.rise_no);
            view.setTag(qVar);
        }
        View findViewById = view.findViewById(com.baidu.tieba.v.bd_list_top_divider);
        View findViewById2 = view.findViewById(com.baidu.tieba.v.bd_list_bottom_divider);
        aw.i(findViewById, com.baidu.tieba.s.ht_title_top_sep_line);
        aw.i(findViewById2, com.baidu.tieba.s.ht_title_top_sep_line);
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        q qVar2 = (q) view.getTag();
        this.mActivity.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.mActivity.getLayoutMode().h(view);
        ForumInfoData forumInfoData = this.awe[i];
        String str = this.awe[i].avatar;
        qVar2.awf.setTag(str);
        qVar2.awf.invalidate();
        qVar2.awf.c(str, 10, false);
        qVar2.awi.setText(forumInfoData.forum_name);
        qVar2.awi.setTag(Integer.valueOf(forumInfoData.forum_id));
        qVar2.awm.setTag(forumInfoData.forum_name);
        qVar2.awj.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.forum_list_attention_tv)) + " " + eB(forumInfoData.member_count));
        qVar2.awk.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.forum_list_thread_tv)) + " " + eB(forumInfoData.thread_count));
        qVar2.awl.setText(forumInfoData.slogan);
        if (this.awc == 0) {
            qVar2.awh.setVisibility(8);
            if (!this.avG) {
                qVar2.awg.setVisibility(8);
            } else {
                qVar2.awg.setVisibility(0);
                qVar2.awg.setText((CharSequence) null);
                qVar2.awg.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        aw.h((View) qVar2.awg, com.baidu.tieba.u.icon_brief_grade_orange);
                        break;
                    case 1:
                        aw.h((View) qVar2.awg, com.baidu.tieba.u.icon_brief_grade_blue);
                        break;
                    case 2:
                        aw.h((View) qVar2.awg, com.baidu.tieba.u.icon_brief_grade_green);
                        break;
                    default:
                        qVar2.awg.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            qVar2.awg.setVisibility(8);
            qVar2.awh.setVisibility(0);
            qVar2.awh.setText((CharSequence) null);
            qVar2.awh.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            qVar2.awh.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.rise)) + String.valueOf(forumInfoData.mbr_inter_rank) + this.mActivity.getString(com.baidu.tieba.y.number));
        }
        qVar2.awm.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.like) {
            TiebaStatic.eventStat(this.mActivity, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.mActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mActivity).createNormalCfg((String) view.getTag(), null)));
            return;
        }
        q qVar = (q) view.getTag();
        if (com.baidu.adp.lib.b.f.db().U(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR) == 0) {
            ForumDetailActivity.a(this.mActivity, String.valueOf(qVar.awi.getTag()), this.awd);
            return;
        }
        TiebaStatic.eventStat(this.mActivity, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.mActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mActivity).createNormalCfg(qVar.awi.getText().toString(), null)));
    }

    public String eB(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / TbConfig.BIG_IMAGE_MIN_CAPACITY)) + this.mActivity.getString(com.baidu.tieba.y.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void bG(boolean z) {
        this.ly = z;
        notifyDataSetChanged();
    }
}
