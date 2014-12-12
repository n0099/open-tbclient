package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import tbclient.RecommendForumInfo;
/* loaded from: classes.dex */
public class ItemFootNavView extends LinearLayout {
    private RecommendForumInfo aZc;
    private ForumDetailActivity aZf;
    private ViewGroup aZr;
    private TextView aZs;
    private ImageView aZt;
    private ViewGroup aZu;
    private View aZv;
    private boolean aZw;
    private View aZx;
    private com.baidu.tbadk.core.dialog.a aZy;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.aZw = false;
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aZw = false;
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        com.baidu.adp.lib.g.b.ek().a(context, x.forum_detail_foot_nav, this, true);
        setOrientation(1);
        setVisibility(8);
        this.aZr = (ViewGroup) findViewById(com.baidu.tieba.w.fn_care_box);
        this.aZs = (TextView) findViewById(com.baidu.tieba.w.fn_care_btn);
        this.aZt = (ImageView) findViewById(com.baidu.tieba.w.icon_brief_care);
        this.aZu = (ViewGroup) findViewById(com.baidu.tieba.w.fn_enter_box);
        this.aZv = findViewById(com.baidu.tieba.w.foot_line);
    }

    public void a(RecommendForumInfo recommendForumInfo, ForumDetailActivity forumDetailActivity) {
        this.aZf = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.aZw = forumDetailActivity.getIntent().getStringExtra(ForumDetailActivityConfig.FROM_TYPE).equals(ForumDetailActivityConfig.FromType.FRS.toString());
            this.aZc = recommendForumInfo;
            String str = recommendForumInfo.forum_name;
            cM(recommendForumInfo.is_like.intValue() == 1);
            this.aZr.setOnClickListener(new o(this, forumDetailActivity));
            this.aZu.setOnClickListener(new p(this, forumDetailActivity, str));
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        boolean z = (TbadkCoreApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccountName() == null) ? false : true;
        Object tag = this.aZs.getTag();
        boolean z2 = (tag == null || ((Integer) tag).intValue() != 2) ? true : true;
        if (!z && !z2) {
            this.aZs.setTag(2);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) forumDetailActivity.getPageContext().getPageActivity(), getResources().getString(z.login_to_use), true, 11034)));
            return;
        }
        this.aZs.setTag(3);
        int intValue = ((Integer) this.aZr.getTag()).intValue();
        if (intValue == 0) {
            a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.aZw);
        } else if (intValue == 1) {
            a(forumDetailActivity, this.aZw);
        }
        TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(boolean z) {
        if (this.aZx == null) {
            this.aZx = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, x.forum_detail_attention_toast, null);
        }
        ImageView imageView = (ImageView) this.aZx.findViewById(com.baidu.tieba.w.attention_icon);
        TextView textView = (TextView) this.aZx.findViewById(com.baidu.tieba.w.attention_title);
        if (z) {
            imageView.setImageDrawable(ax.getDrawable(com.baidu.tieba.v.icon_tips_attention_ok));
            textView.setText(z.attention_n);
        } else {
            imageView.setImageDrawable(ax.getDrawable(com.baidu.tieba.v.icon_tips_attention_cancel));
            textView.setText(z.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(this.aZx);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.aZf.cJ(true);
        } else {
            this.aZf.cJ(false);
        }
        this.aZf.setSwitch(z);
        this.aZf.cK(z);
    }

    private void a(ForumDetailActivity forumDetailActivity, boolean z) {
        ac acVar = new ac(forumDetailActivity.getPageContext());
        acVar.setFrom("detail_follow");
        acVar.setLoadDataCallBack(new q(this, acVar, forumDetailActivity));
        acVar.aN(this.aZc.forum_name, String.valueOf(this.aZc.forum_id));
    }

    private void a(BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.aZy == null) {
            this.aZy = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.aZy.bt(z.forum_info_unlike_msg);
            this.aZy.a(z.alert_yes_button, new r(this, baseActivity));
            this.aZy.b(z.alert_no_button, new t(this));
            this.aZy.ag(true);
        }
        this.aZy.b(baseActivity.getPageContext()).nU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM(boolean z) {
        int i;
        if (z) {
            ax.c(this.aZt, com.baidu.tieba.v.icon_pop_pass);
            i = z.followed_title;
            this.aZr.setTag(0);
        } else {
            ax.c(this.aZt, com.baidu.tieba.v.icon_brief_attention);
            i = z.attention;
            this.aZr.setTag(1);
        }
        this.aZs.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().ab(i == 1);
        forumDetailActivity.getLayoutMode().h(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
        Object tag;
        if (this.aZs != null && (tag = this.aZs.getTag()) != null && ((Integer) tag).intValue() == 2) {
            d(forumDetailActivity);
        }
    }

    public void cN(boolean z) {
        if (z) {
            this.aZv.setVisibility(0);
        } else {
            this.aZv.setVisibility(8);
        }
    }
}
