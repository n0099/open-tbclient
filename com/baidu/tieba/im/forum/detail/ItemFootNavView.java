package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel azn;
    private AntiHelper.a dGL;
    private RecommendForumInfo eqG;
    private ForumDetailActivity eqM;
    private ViewGroup eqZ;
    private TextView era;
    private ImageView erb;
    private ViewGroup erc;
    private View erd;
    private boolean ere;
    private com.baidu.tbadk.core.dialog.a erf;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.ere = false;
        this.dGL = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.aru));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.aru));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ere = false;
        this.dGL = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").r("obj_locate", at.a.aru));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").r("obj_locate", at.a.aru));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(f.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.eqZ = (ViewGroup) findViewById(f.g.fn_care_box);
        this.era = (TextView) findViewById(f.g.fn_care_btn);
        this.erb = (ImageView) findViewById(f.g.icon_brief_care);
        this.erc = (ViewGroup) findViewById(f.g.fn_enter_box);
        this.erd = findViewById(f.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.eqM = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.ere = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.eqG = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            hu(recommendForumInfo.is_like.intValue() == 1);
            this.eqZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.erc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.ere) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.uX())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.eqM.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.eqZ.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.ere);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.uX())) {
                    TiebaStatic.eventStat(this.eqM.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.ere);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ht(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(f.h.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(f.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(f.g.attention_title);
        am.h(textView, f.d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(am.getDrawable(f.C0146f.icon_tips_attention_ok));
            textView.setText(f.j.attention);
        } else {
            imageView.setImageDrawable(am.getDrawable(f.C0146f.icon_tips_attention_cancel));
            textView.setText(f.j.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.eqM.hq(true);
        } else {
            this.eqM.hq(false);
        }
        this.eqM.setSwitch(z);
        this.eqM.hr(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.azn == null) {
            this.azn = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.azn.setFrom("detail_follow");
        this.azn.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (ItemFootNavView.this.azn.getErrorCode() == 22) {
                    ItemFootNavView.this.ht(true);
                    ItemFootNavView.this.hu(true);
                } else if (!AntiHelper.al(ItemFootNavView.this.azn.getErrorCode(), ItemFootNavView.this.azn.getErrorString())) {
                    if (ItemFootNavView.this.azn.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.azn.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), f.C0146f.icon_toast_game_error, 3000).xm();
                            return;
                        } else if (!AntiHelper.tO(rVar.getErrorCode())) {
                            ItemFootNavView.this.ht(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.eqG.forum_name);
                            ItemFootNavView.this.hu(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.azn.getBlockPopInfoData(), ItemFootNavView.this.dGL);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(f.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.azn.getBlockPopInfoData(), ItemFootNavView.this.dGL) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.aru));
                }
            }
        });
        this.azn.ck(this.eqG.forum_name, String.valueOf(this.eqG.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.erf == null) {
            this.erf = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.erf.cf(f.j.forum_info_unlike_msg);
            this.erf.a(f.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.erf.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void m(String str, long j) {
                            ItemFootNavView.this.ht(false);
                            ItemFootNavView.this.hu(false);
                            if (ItemFootNavView.this.eqG != null && ItemFootNavView.this.eqG.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.eqG.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void n(String str, long j) {
                            if (j == 3250013) {
                                if (ap.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(f.j.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, f.C0146f.icon_toast_game_error, 3000).xm();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(f.j.unlike_failure));
                        }
                    });
                    wVar.t(ItemFootNavView.this.eqG.forum_name, ItemFootNavView.this.eqG.forum_id.longValue());
                }
            });
            this.erf.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.erf.dismiss();
                }
            });
            this.erf.aw(true);
        }
        this.erf.b(baseActivity.getPageContext()).xe();
    }

    public void hu(boolean z) {
        int i;
        if (z) {
            am.c(this.erb, f.C0146f.icon_pop_pass);
            i = f.j.relate_forum_is_followed;
            this.eqZ.setTag(0);
        } else {
            am.c(this.erb, f.C0146f.icon_brief_attention);
            i = f.j.attention;
            this.eqZ.setTag(1);
        }
        this.era.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void hv(boolean z) {
        if (z) {
            this.erd.setVisibility(0);
        } else {
            this.erd.setVisibility(8);
        }
    }
}
