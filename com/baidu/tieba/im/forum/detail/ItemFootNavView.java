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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel aGV;
    private AntiHelper.a dVN;
    private RecommendForumInfo eFL;
    private ForumDetailActivity eFR;
    private ViewGroup eGe;
    private TextView eGf;
    private ImageView eGg;
    private ViewGroup eGh;
    private View eGi;
    private boolean eGj;
    private com.baidu.tbadk.core.dialog.a eGk;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.eGj = false;
        this.dVN = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayD));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayD));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eGj = false;
        this.dVN = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.ayD));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.ayD));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.eGe = (ViewGroup) findViewById(e.g.fn_care_box);
        this.eGf = (TextView) findViewById(e.g.fn_care_btn);
        this.eGg = (ImageView) findViewById(e.g.icon_brief_care);
        this.eGh = (ViewGroup) findViewById(e.g.fn_enter_box);
        this.eGi = findViewById(e.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.eFR = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.eGj = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.eFL = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            ik(recommendForumInfo.is_like.intValue() == 1);
            this.eGe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.eGh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    if (ItemFootNavView.this.eGj) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.yj())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.eFR.getPageContext().getPageActivity(), "squae_introduce_entry", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.eGe.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.eGj);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.yj())) {
                    TiebaStatic.eventStat(this.eFR.getPageContext().getPageActivity(), "squae_introduce_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                a(forumDetailActivity, this.eGj);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ij(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(e.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(e.g.attention_title);
        al.h(textView, e.d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(al.getDrawable(e.f.icon_tips_attention_ok));
            textView.setText(e.j.attention);
        } else {
            imageView.setImageDrawable(al.getDrawable(e.f.icon_tips_attention_cancel));
            textView.setText(e.j.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.eFR.ig(true);
        } else {
            this.eFR.ig(false);
        }
        this.eFR.setSwitch(z);
        this.eFR.ih(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.aGV == null) {
            this.aGV = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.aGV.setFrom("detail_follow");
        this.aGV.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.aGV.getErrorCode() == 22) {
                    ItemFootNavView.this.ij(true);
                    ItemFootNavView.this.ik(true);
                } else if (!AntiHelper.am(ItemFootNavView.this.aGV.getErrorCode(), ItemFootNavView.this.aGV.getErrorString())) {
                    if (ItemFootNavView.this.aGV.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.aGV.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).AC();
                            return;
                        } else if (!AntiHelper.uL(rVar.getErrorCode())) {
                            ItemFootNavView.this.ij(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.eFL.forum_name);
                            ItemFootNavView.this.ik(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.aGV.getBlockPopInfoData(), ItemFootNavView.this.dVN);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(e.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.aGV.getBlockPopInfoData(), ItemFootNavView.this.dVN) != null) {
                    TiebaStatic.log(new am("c12534").x("obj_locate", as.a.ayD));
                }
            }
        });
        this.aGV.cF(this.eFL.forum_name, String.valueOf(this.eFL.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.eGk == null) {
            this.eGk = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.eGk.cz(e.j.forum_info_unlike_msg);
            this.eGk.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eGk.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void p(String str, long j) {
                            ItemFootNavView.this.ij(false);
                            ItemFootNavView.this.ik(false);
                            if (ItemFootNavView.this.eFL != null && ItemFootNavView.this.eFL.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.eFL.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void q(String str, long j) {
                            if (j == 3250013) {
                                if (ao.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(e.j.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, e.f.icon_toast_game_error, 3000).AC();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(e.j.unlike_failure));
                        }
                    });
                    wVar.w(ItemFootNavView.this.eFL.forum_name, ItemFootNavView.this.eFL.forum_id.longValue());
                }
            });
            this.eGk.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eGk.dismiss();
                }
            });
            this.eGk.aP(true);
        }
        this.eGk.b(baseActivity.getPageContext()).Au();
    }

    public void ik(boolean z) {
        int i;
        if (z) {
            al.c(this.eGg, e.f.icon_pop_pass);
            i = e.j.relate_forum_is_followed;
            this.eGe.setTag(0);
        } else {
            al.c(this.eGg, e.f.icon_brief_attention);
            i = e.j.attention;
            this.eGe.setTag(1);
        }
        this.eGf.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void il(boolean z) {
        if (z) {
            this.eGi.setVisibility(0);
        } else {
            this.eGi.setVisibility(8);
        }
    }
}
