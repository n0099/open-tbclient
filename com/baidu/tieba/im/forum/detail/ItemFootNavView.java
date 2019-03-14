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
    private LikeModel bUq;
    private AntiHelper.a fvT;
    private RecommendForumInfo ghC;
    private ForumDetailActivity ghK;
    private ViewGroup ghX;
    private TextView ghY;
    private ImageView ghZ;
    private ViewGroup gia;
    private View gib;
    private boolean gic;
    private com.baidu.tbadk.core.dialog.a gie;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.gic = false;
        this.fvT = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLq));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLq));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gic = false;
        this.fvT = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").T("obj_locate", at.a.bLq));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").T("obj_locate", at.a.bLq));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(d.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.ghX = (ViewGroup) findViewById(d.g.fn_care_box);
        this.ghY = (TextView) findViewById(d.g.fn_care_btn);
        this.ghZ = (ImageView) findViewById(d.g.icon_brief_care);
        this.gia = (ViewGroup) findViewById(d.g.fn_enter_box);
        this.gib = findViewById(d.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.ghK = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.gic = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.ghC = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            kZ(recommendForumInfo.is_like.intValue() == 1);
            this.ghX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.gia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.gic) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.YE())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.ghK.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.ghX.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.gic);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.YE())) {
                    TiebaStatic.eventStat(this.ghK.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.gic);
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
            this.ghK.kV(true);
        } else {
            this.ghK.kV(false);
        }
        this.ghK.setSwitch(z);
        this.ghK.kW(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.bUq == null) {
            this.bUq = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.bUq.setFrom("detail_follow");
        this.bUq.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.bUq.getErrorCode() == 22) {
                    ItemFootNavView.this.kY(true);
                    ItemFootNavView.this.kZ(true);
                } else if (!AntiHelper.aB(ItemFootNavView.this.bUq.getErrorCode(), ItemFootNavView.this.bUq.getErrorString())) {
                    if (ItemFootNavView.this.bUq.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.bUq.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), d.f.icon_toast_game_error, 3000).abh();
                            return;
                        } else if (!AntiHelper.zz(rVar.getErrorCode())) {
                            ItemFootNavView.this.kY(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.ghC.forum_name);
                            ItemFootNavView.this.kZ(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.bUq.getBlockPopInfoData(), ItemFootNavView.this.fvT);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(d.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.bUq.getBlockPopInfoData(), ItemFootNavView.this.fvT) != null) {
                    TiebaStatic.log(new am("c12534").T("obj_locate", at.a.bLq));
                }
            }
        });
        this.bUq.dV(this.ghC.forum_name, String.valueOf(this.ghC.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.gie == null) {
            this.gie = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.gie.gD(d.j.forum_info_unlike_msg);
            this.gie.a(d.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gie.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void s(String str, long j) {
                            ItemFootNavView.this.kY(false);
                            ItemFootNavView.this.kZ(false);
                            if (ItemFootNavView.this.ghC != null && ItemFootNavView.this.ghC.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.ghC.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void t(String str, long j) {
                            if (j == 3250013) {
                                if (ap.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(d.j.anti_account_exception_appealing);
                                }
                                BdToast.b(TbadkCoreApplication.getInst().getContext(), str, d.f.icon_toast_game_error, 3000).abh();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(d.j.unlike_failure));
                        }
                    });
                    wVar.A(ItemFootNavView.this.ghC.forum_name, ItemFootNavView.this.ghC.forum_id.longValue());
                }
            });
            this.gie.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gie.dismiss();
                }
            });
            this.gie.dr(true);
        }
        this.gie.b(baseActivity.getPageContext()).aaZ();
    }

    public void kZ(boolean z) {
        int i;
        if (z) {
            al.c(this.ghZ, d.f.icon_pop_pass);
            i = d.j.relate_forum_is_followed;
            this.ghX.setTag(0);
        } else {
            al.c(this.ghZ, d.f.icon_brief_attention);
            i = d.j.attention;
            this.ghX.setTag(1);
        }
        this.ghY.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void la(boolean z) {
        if (z) {
            this.gib.setVisibility(0);
        } else {
            this.gib.setVisibility(8);
        }
    }
}
