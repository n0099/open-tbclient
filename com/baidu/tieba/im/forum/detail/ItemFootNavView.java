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
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel cdr;
    private AntiHelper.a fRw;
    private RecommendForumInfo gEQ;
    private ForumDetailActivity gEX;
    private ViewGroup gFk;
    private TextView gFl;
    private ImageView gFm;
    private ViewGroup gFn;
    private View gFo;
    private boolean gFp;
    private com.baidu.tbadk.core.dialog.a gFq;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.gFp = false;
        this.fRw = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUh));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUh));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gFp = false;
        this.fRw = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUh));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUh));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.gFk = (ViewGroup) findViewById(R.id.fn_care_box);
        this.gFl = (TextView) findViewById(R.id.fn_care_btn);
        this.gFm = (ImageView) findViewById(R.id.icon_brief_care);
        this.gFn = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.gFo = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.gEX = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.gFp = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.gEQ = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            md(recommendForumInfo.is_like.intValue() == 1);
            this.gFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.gFn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.gFp) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aek())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.gEX.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.gFk.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.gFp);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aek())) {
                    TiebaStatic.eventStat(this.gEX.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.gFp);
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
            this.gEX.lZ(true);
        } else {
            this.gEX.lZ(false);
        }
        this.gEX.setSwitch(z);
        this.gEX.ma(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.cdr == null) {
            this.cdr = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.cdr.setFrom("detail_follow");
        this.cdr.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.cdr.getErrorCode() == 22) {
                    ItemFootNavView.this.mc(true);
                    ItemFootNavView.this.md(true);
                } else if (!AntiHelper.aG(ItemFootNavView.this.cdr.getErrorCode(), ItemFootNavView.this.cdr.getErrorString())) {
                    if (ItemFootNavView.this.cdr.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.cdr.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).agQ();
                            return;
                        } else if (!AntiHelper.Bj(rVar.getErrorCode())) {
                            ItemFootNavView.this.mc(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.gEQ.forum_name);
                            ItemFootNavView.this.md(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cdr.getBlockPopInfoData(), ItemFootNavView.this.fRw);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.cdr.getBlockPopInfoData(), ItemFootNavView.this.fRw) != null) {
                    TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUh));
                }
            }
        });
        this.cdr.el(this.gEQ.forum_name, String.valueOf(this.gEQ.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.gFq == null) {
            this.gFq = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.gFq.hu(R.string.forum_info_unlike_msg);
            this.gFq.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gFq.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void u(String str, long j) {
                            ItemFootNavView.this.mc(false);
                            ItemFootNavView.this.md(false);
                            if (ItemFootNavView.this.gEQ != null && ItemFootNavView.this.gEQ.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.gEQ.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void v(String str, long j) {
                            if (j == 3250013) {
                                if (aq.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.b(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_toast_game_error, 3000).agQ();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    wVar.C(ItemFootNavView.this.gEQ.forum_name, ItemFootNavView.this.gEQ.forum_id.longValue());
                }
            });
            this.gFq.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.gFq.dismiss();
                }
            });
            this.gFq.dR(true);
        }
        this.gFq.b(baseActivity.getPageContext()).agI();
    }

    public void md(boolean z) {
        int i;
        if (z) {
            am.c(this.gFm, (int) R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.gFk.setTag(0);
        } else {
            am.c(this.gFm, (int) R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.gFk.setTag(1);
        }
        this.gFl.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void me(boolean z) {
        if (z) {
            this.gFo.setVisibility(0);
        } else {
            this.gFo.setVisibility(8);
        }
    }
}
