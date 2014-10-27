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
    private int avT;
    private ag avr;
    private BaseActivity mActivity;
    public int avS = -1;
    private int Af = 0;
    private boolean avx = true;
    private ForumDetailActivity.FromType avU = ForumDetailActivity.FromType.BAR_DIR;
    private boolean ly = false;
    private ForumInfoData[] avV = new ForumInfoData[0];

    public p(BaseActivity baseActivity, int i) {
        this.avT = 0;
        this.mActivity = baseActivity;
        this.avT = i;
    }

    public ForumInfoData[] DP() {
        return this.avV;
    }

    public void a(ForumDetailActivity.FromType fromType) {
        this.avU = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.avV = forumInfoDataArr;
        if (this.avV != null) {
            notifyDataSetChanged();
        }
    }

    public void a(ag agVar) {
        this.avr = agVar;
    }

    public void H(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void DQ() {
        for (int i = 0; i < this.Af; i++) {
            int dV = aj.wk().dV(this.avV[i].forum_name);
            if (dV == 1) {
                this.avV[i].is_like = 1;
            } else if (dV == -1) {
                this.avV[i].is_like = 0;
            }
        }
    }

    public boolean DR() {
        if (this.avr == null) {
            return false;
        }
        return this.avr.TG();
    }

    public void eA(int i) {
        this.Af = i;
        notifyDataSetChanged();
    }

    public void e(Boolean bool) {
        this.avx = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.avV == null) {
            return 0;
        }
        return this.Af <= this.avV.length ? this.Af : this.avV.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.Af) {
            return null;
        }
        return this.avV[i];
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
            qVar.avW = (BarImageView) view.findViewById(com.baidu.tieba.v.forum_avatar);
            qVar.avW.setGifIconSupport(false);
            qVar.avZ = (TextView) view.findViewById(com.baidu.tieba.v.name);
            qVar.awa = (TextView) view.findViewById(com.baidu.tieba.v.member_count);
            qVar.awb = (TextView) view.findViewById(com.baidu.tieba.v.thread_count);
            qVar.awc = (TextView) view.findViewById(com.baidu.tieba.v.slogan);
            qVar.awd = (TextView) view.findViewById(com.baidu.tieba.v.like);
            qVar.avX = (TextView) view.findViewById(com.baidu.tieba.v.rank_badge);
            qVar.avY = (TextView) view.findViewById(com.baidu.tieba.v.rise_no);
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
        ForumInfoData forumInfoData = this.avV[i];
        String str = this.avV[i].avatar;
        qVar2.avW.setTag(str);
        qVar2.avW.invalidate();
        qVar2.avW.c(str, 10, false);
        qVar2.avZ.setText(forumInfoData.forum_name);
        qVar2.avZ.setTag(Integer.valueOf(forumInfoData.forum_id));
        qVar2.awd.setTag(forumInfoData.forum_name);
        qVar2.awa.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.forum_list_attention_tv)) + " " + eB(forumInfoData.member_count));
        qVar2.awb.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.forum_list_thread_tv)) + " " + eB(forumInfoData.thread_count));
        qVar2.awc.setText(forumInfoData.slogan);
        if (this.avT == 0) {
            qVar2.avY.setVisibility(8);
            if (!this.avx) {
                qVar2.avX.setVisibility(8);
            } else {
                qVar2.avX.setVisibility(0);
                qVar2.avX.setText((CharSequence) null);
                qVar2.avX.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        aw.h((View) qVar2.avX, com.baidu.tieba.u.icon_brief_grade_orange);
                        break;
                    case 1:
                        aw.h((View) qVar2.avX, com.baidu.tieba.u.icon_brief_grade_blue);
                        break;
                    case 2:
                        aw.h((View) qVar2.avX, com.baidu.tieba.u.icon_brief_grade_green);
                        break;
                    default:
                        qVar2.avX.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            qVar2.avX.setVisibility(8);
            qVar2.avY.setVisibility(0);
            qVar2.avY.setText((CharSequence) null);
            qVar2.avY.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_rise), (Drawable) null, (Drawable) null, (Drawable) null);
            qVar2.avY.setText(String.valueOf(this.mActivity.getString(com.baidu.tieba.y.rise)) + String.valueOf(forumInfoData.mbr_inter_rank) + this.mActivity.getString(com.baidu.tieba.y.number));
        }
        qVar2.awd.setOnClickListener(this);
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
            ForumDetailActivity.a(this.mActivity, String.valueOf(qVar.avZ.getTag()), this.avU);
            return;
        }
        TiebaStatic.eventStat(this.mActivity, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.mActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mActivity).createNormalCfg(qVar.avZ.getText().toString(), null)));
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
