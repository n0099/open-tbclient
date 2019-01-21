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
    private LikeModel aLQ;
    private ForumDetailActivity eRF;
    private ViewGroup eRS;
    private TextView eRT;
    private ImageView eRU;
    private ViewGroup eRV;
    private View eRW;
    private boolean eRX;
    private com.baidu.tbadk.core.dialog.a eRY;
    private RecommendForumInfo eRz;
    private AntiHelper.a egW;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.eRX = false;
        this.egW = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDu));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDu));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eRX = false;
        this.egW = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12536").y("obj_locate", as.a.aDu));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new am("c12535").y("obj_locate", as.a.aDu));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.eRS = (ViewGroup) findViewById(e.g.fn_care_box);
        this.eRT = (TextView) findViewById(e.g.fn_care_btn);
        this.eRU = (ImageView) findViewById(e.g.icon_brief_care);
        this.eRV = (ViewGroup) findViewById(e.g.fn_enter_box);
        this.eRW = findViewById(e.g.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.eRF = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.eRX = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.eRz = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            iz(recommendForumInfo.is_like.intValue() == 1);
            this.eRS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.eRV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    if (ItemFootNavView.this.eRX) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, "bar_detail")));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.zH())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.eRF.getPageContext().getPageActivity(), "squae_introduce_entry", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.eRS.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.eRX);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.zH())) {
                    TiebaStatic.eventStat(this.eRF.getPageContext().getPageActivity(), "squae_introduce_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                }
                a(forumDetailActivity, this.eRX);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iy(boolean z) {
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
            this.eRF.iv(true);
        } else {
            this.eRF.iv(false);
        }
        this.eRF.setSwitch(z);
        this.eRF.iw(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.aLQ == null) {
            this.aLQ = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.aLQ.setFrom("detail_follow");
        this.aLQ.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (ItemFootNavView.this.aLQ.getErrorCode() == 22) {
                    ItemFootNavView.this.iy(true);
                    ItemFootNavView.this.iz(true);
                } else if (!AntiHelper.al(ItemFootNavView.this.aLQ.getErrorCode(), ItemFootNavView.this.aLQ.getErrorString())) {
                    if (ItemFootNavView.this.aLQ.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.aLQ.getErrorString());
                        return;
                    }
                    r rVar = (r) obj;
                    if (rVar != null) {
                        if (rVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).Ca();
                            return;
                        } else if (!AntiHelper.vQ(rVar.getErrorCode())) {
                            ItemFootNavView.this.iy(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.eRz.forum_name);
                            ItemFootNavView.this.iz(true);
                            rVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.aLQ.getBlockPopInfoData(), ItemFootNavView.this.egW);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(e.j.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.aLQ.getBlockPopInfoData(), ItemFootNavView.this.egW) != null) {
                    TiebaStatic.log(new am("c12534").y("obj_locate", as.a.aDu));
                }
            }
        });
        this.aLQ.cM(this.eRz.forum_name, String.valueOf(this.eRz.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.eRY == null) {
            this.eRY = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.eRY.db(e.j.forum_info_unlike_msg);
            this.eRY.a(e.j.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eRY.dismiss();
                    w wVar = new w();
                    wVar.setFrom("bar_detail");
                    wVar.a(new w.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void p(String str, long j) {
                            ItemFootNavView.this.iy(false);
                            ItemFootNavView.this.iz(false);
                            if (ItemFootNavView.this.eRz != null && ItemFootNavView.this.eRz.forum_id.longValue() != 0) {
                                r rVar = new r();
                                rVar.setFid(j + "");
                                rVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage(2003004, ItemFootNavView.this.eRz.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.w.a
                        public void q(String str, long j) {
                            if (j == 3250013) {
                                if (ao.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(e.j.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, e.f.icon_toast_game_error, 3000).Ca();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(e.j.unlike_failure));
                        }
                    });
                    wVar.w(ItemFootNavView.this.eRz.forum_name, ItemFootNavView.this.eRz.forum_id.longValue());
                }
            });
            this.eRY.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.eRY.dismiss();
                }
            });
            this.eRY.bh(true);
        }
        this.eRY.b(baseActivity.getPageContext()).BS();
    }

    public void iz(boolean z) {
        int i;
        if (z) {
            al.c(this.eRU, e.f.icon_pop_pass);
            i = e.j.relate_forum_is_followed;
            this.eRS.setTag(0);
        } else {
            al.c(this.eRU, e.f.icon_brief_attention);
            i = e.j.attention;
            this.eRS.setTag(1);
        }
        this.eRT.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void iA(boolean z) {
        if (z) {
            this.eRW.setVisibility(0);
        } else {
            this.eRW.setVisibility(8);
        }
    }
}
