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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.y;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel cdy;
    private AntiHelper.a fSk;
    private RecommendForumInfo gFI;
    private ForumDetailActivity gFP;
    private ViewGroup gGc;
    private TextView gGd;
    private ImageView gGe;
    private ViewGroup gGf;
    private View gGg;
    private boolean gGh;
    private com.baidu.tbadk.core.dialog.a gGi;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.gGh = false;
        this.fSk = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUn));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUn));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gGh = false;
        this.fSk = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUn));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUn));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.gGc = (ViewGroup) findViewById(R.id.fn_care_box);
        this.gGd = (TextView) findViewById(R.id.fn_care_btn);
        this.gGe = (ImageView) findViewById(R.id.icon_brief_care);
        this.gGf = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.gGg = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.gFP = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.gGh = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.gFI = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            md(recommendForumInfo.is_like.intValue() == 1);
            this.gGc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.gGf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.gGh) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.ael())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.gFP.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.gGc.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.gGh);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.ael())) {
                    TiebaStatic.eventStat(this.gFP.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.gGh);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mc(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        am.j(textView, R.color.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(am.getDrawable(R.drawable.icon_tips_attention_ok));
            textView.setText(R.string.attention);
        } else {
            imageView.setImageDrawable(am.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.gFP.lZ(true);
        } else {
            this.gFP.lZ(false);
        }
        this.gFP.setSwitch(z);
        this.gFP.ma(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.cdy == null) {
            this.cdy = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.cdy.setFrom("detail_follow");
        this.cdy.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.cdy.getErrorCode() == 22) {
                    ItemFootNavView.this.mc(true);
                    ItemFootNavView.this.md(true);
                } else if (!AntiHelper.aG(ItemFootNavView.this.cdy.getErrorCode(), ItemFootNavView.this.cdy.getErrorString())) {
                    if (ItemFootNavView.this.cdy.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.cdy.getErrorString());
                        return;
                    }
                    t tVar = (t) obj;
                    if (tVar != null) {
                        if (tVar.getErrorCode() == 3250013) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).agS();
                            return;
                        } else if (!AntiHelper.Bl(tVar.getErrorCode())) {
                            ItemFootNavView.this.mc(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.gFI.forum_name);
                            ItemFootNavView.this.md(true);
                            tVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cdy.getBlockPopInfoData(), ItemFootNavView.this.fSk);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cdy.getBlockPopInfoData(), ItemFootNavView.this.fSk) != null) {
                    TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUn));
                }
            }
        });
        this.cdy.el(this.gFI.forum_name, String.valueOf(this.gFI.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.gGi == null) {
            this.gGi = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.gGi.hu(R.string.forum_info_unlike_msg);
            this.gGi.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gGi.dismiss();
                    y yVar = new y();
                    yVar.setFrom("bar_detail");
                    yVar.a(new y.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.y.a
                        public void u(String str, long j) {
                            ItemFootNavView.this.mc(false);
                            ItemFootNavView.this.md(false);
                            if (ItemFootNavView.this.gFI != null && ItemFootNavView.this.gFI.forum_id.longValue() != 0) {
                                t tVar = new t();
                                tVar.setFid(j + "");
                                tVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.gFI.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.y.a
                        public void v(String str, long j) {
                            if (j == 3250013) {
                                if (aq.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.b(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_toast_game_error, 3000).agS();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    yVar.C(ItemFootNavView.this.gFI.forum_name, ItemFootNavView.this.gFI.forum_id.longValue());
                }
            });
            this.gGi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gGi.dismiss();
                }
            });
            this.gGi.dR(true);
        }
        this.gGi.b(baseActivity.getPageContext()).agK();
    }

    public void md(boolean z) {
        int i;
        if (z) {
            am.c(this.gGe, (int) R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.gGc.setTag(0);
        } else {
            am.c(this.gGe, (int) R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.gGc.setTag(1);
        }
        this.gGd.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void me(boolean z) {
        if (z) {
            this.gGg.setVisibility(0);
        } else {
            this.gGg.setVisibility(8);
        }
    }
}
