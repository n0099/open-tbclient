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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel bUt;
    private AntiHelper.a fvF;
    private ViewGroup ghL;
    private TextView ghM;
    private ImageView ghN;
    private ViewGroup ghO;
    private View ghP;
    private boolean ghQ;
    private com.baidu.tbadk.core.dialog.a ghR;
    private RecommendForumInfo ghq;
    private ForumDetailActivity ghy;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.ghQ = false;
        this.fvF = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLt));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLt));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghQ = false;
        this.fvF = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLt));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLt));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.ghL = (ViewGroup) findViewById(d.g.fn_care_box);
        this.ghM = (TextView) findViewById(d.g.fn_care_btn);
        this.ghN = (ImageView) findViewById(d.g.icon_brief_care);
        this.ghO = (ViewGroup) findViewById(d.g.fn_enter_box);
        this.ghP = findViewById(d.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.ghy = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.ghQ = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.ghq = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            kZ(recommendForumInfo.is_like.intValue() == 1);
            this.ghL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.ghO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.ghQ) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.YB())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.ghy.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.ghL.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.ghQ);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.YB())) {
                    TiebaStatic.eventStat(this.ghy.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.ghQ);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kY(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(d.g.attention_icon);
        TextView textView = (TextView) inflate.findViewById(d.g.attention_title);
        al.j(textView, d.C0277d.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(al.getDrawable(d.f.icon_tips_attention_ok));
            textView.setText(d.j.attention);
        } else {
            imageView.setImageDrawable(al.getDrawable(d.f.icon_tips_attention_cancel));
            textView.setText(d.j.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.ghy.kV(true);
        } else {
            this.ghy.kV(false);
        }
        this.ghy.setSwitch(z);
        this.ghy.kW(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.bUt == null) {
            this.bUt = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.bUt.setFrom("detail_follow");
        this.bUt.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.bUt.getErrorCode() == 22) {
                    ItemFootNavView.this.kY(true);
                    ItemFootNavView.this.kZ(true);
                } else if (!AntiHelper.aD(ItemFootNavView.this.bUt.getErrorCode(), ItemFootNavView.this.bUt.getErrorString())) {
                    if (ItemFootNavView.this.bUt.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.bUt.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).abe();
                            return;
                        } else if (!AntiHelper.zv(rVar.getErrorCode())) {
                            ItemFootNavView.this.kY(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.ghq.forum_name);
                            ItemFootNavView.this.kZ(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.bUt.getBlockPopInfoData(), ItemFootNavView.this.fvF);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(d.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.bUt.getBlockPopInfoData(), ItemFootNavView.this.fvF) != null) {
                    TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLt));
                }
            }
        });
        this.bUt.dW(this.ghq.forum_name, String.valueOf(this.ghq.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.ghR == null) {
            this.ghR = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.ghR.gC(d.j.forum_info_unlike_msg);
            this.ghR.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.ghR.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void s(String str, long j) {
                            ItemFootNavView.this.kY(false);
                            ItemFootNavView.this.kZ(false);
                            if (ItemFootNavView.this.ghq != null && ItemFootNavView.this.ghq.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.ghq.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void t(String str, long j) {
                            if (j == 3250013) {
                                if (ap.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(d.j.anti_account_exception_appealing);
                                }
                                BdToast.b(TbadkCoreApplication.getInst().getContext(), str, d.f.icon_toast_game_error, 3000).abe();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(d.j.unlike_failure));
                        }
                    });
                    wVar.A(ItemFootNavView.this.ghq.forum_name, ItemFootNavView.this.ghq.forum_id.longValue());
                }
            });
            this.ghR.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.ghR.dismiss();
                }
            });
            this.ghR.dr(true);
        }
        this.ghR.b(baseActivity.getPageContext()).aaW();
    }

    public void kZ(boolean z) {
        int i;
        if (z) {
            al.c(this.ghN, d.f.icon_pop_pass);
            i = d.j.relate_forum_is_followed;
            this.ghL.setTag(0);
        } else {
            al.c(this.ghN, d.f.icon_brief_attention);
            i = d.j.attention;
            this.ghL.setTag(1);
        }
        this.ghM.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void la(boolean z) {
        if (z) {
            this.ghP.setVisibility(0);
        } else {
            this.ghP.setVisibility(8);
        }
    }
}
