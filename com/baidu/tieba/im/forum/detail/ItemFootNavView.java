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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.RecommendForumInfo;
/* loaded from: classes20.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel emT;
    private RecommendForumInfo iYG;
    private ForumDetailActivity iYN;
    private ViewGroup iZb;
    private TextView iZc;
    private ImageView iZd;
    private ViewGroup iZe;
    private View iZf;
    private boolean iZg;
    private com.baidu.tbadk.core.dialog.a iZh;
    private AntiHelper.a ifO;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.iZg = false;
        this.ifO = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iZg = false;
        this.ifO = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.iZb = (ViewGroup) findViewById(R.id.fn_care_box);
        this.iZc = (TextView) findViewById(R.id.fn_care_btn);
        this.iZd = (ImageView) findViewById(R.id.icon_brief_care);
        this.iZe = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.iZf = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.iYN = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.iZg = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.iYG = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            pT(recommendForumInfo.is_like.intValue() == 1);
            this.iZb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.iZe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.iZg) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aVX())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.iYN.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.iZb.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.iZg);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aVX())) {
                    TiebaStatic.eventStat(this.iYN.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.iZg);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        ao.setViewTextColor(textView, R.color.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(ao.getDrawable(R.drawable.icon_tips_attention_ok));
            textView.setText(R.string.attention);
        } else {
            imageView.setImageDrawable(ao.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.iYN.pP(true);
        } else {
            this.iYN.pP(false);
        }
        this.iYN.setSwitch(z);
        this.iYN.pQ(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.emT == null) {
            this.emT = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.emT.setFrom("detail_follow");
        this.emT.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (ItemFootNavView.this.emT.getErrorCode() == 22) {
                    ItemFootNavView.this.pS(true);
                    ItemFootNavView.this.pT(true);
                } else if (!AntiHelper.bB(ItemFootNavView.this.emT.getErrorCode(), ItemFootNavView.this.emT.getErrorString())) {
                    if (ItemFootNavView.this.emT.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.emT.getErrorString());
                        return;
                    }
                    u uVar = (u) obj;
                    if (uVar != null) {
                        if (uVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aYR();
                            return;
                        } else if (!AntiHelper.FA(uVar.getErrorCode())) {
                            ItemFootNavView.this.pS(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.iYG.forum_name);
                            ItemFootNavView.this.pT(true);
                            uVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.emT.getBlockPopInfoData(), ItemFootNavView.this.ifO);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.emT.getBlockPopInfoData(), ItemFootNavView.this.ifO) != null) {
                    TiebaStatic.log(new ap(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ah("obj_locate", aw.a.LOCATE_LIKE_BAR));
                }
            }
        });
        this.emT.fz(this.iYG.forum_name, String.valueOf(this.iYG.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.iZh == null) {
            this.iZh = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.iZh.ln(R.string.forum_info_unlike_msg);
            this.iZh.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.iZh.dismiss();
                    ac acVar = new ac();
                    acVar.setFrom(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                    acVar.a(new ac.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void x(String str, long j) {
                            ItemFootNavView.this.pS(false);
                            ItemFootNavView.this.pT(false);
                            if (ItemFootNavView.this.iYG != null && ItemFootNavView.this.iYG.forum_id.longValue() != 0) {
                                u uVar = new u();
                                uVar.setFid(j + "");
                                uVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, ItemFootNavView.this.iYG.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void y(String str, long j) {
                            if (j == 3250013) {
                                if (as.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aYR();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    acVar.J(ItemFootNavView.this.iYG.forum_name, ItemFootNavView.this.iYG.forum_id.longValue());
                }
            });
            this.iZh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.iZh.dismiss();
                }
            });
            this.iZh.hK(true);
        }
        this.iZh.b(baseActivity.getPageContext()).aYL();
    }

    public void pT(boolean z) {
        int i;
        if (z) {
            ao.setImageResource(this.iZd, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.iZb.setTag(0);
        } else {
            ao.setImageResource(this.iZd, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.iZb.setTag(1);
        }
        this.iZc.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void pU(boolean z) {
        if (z) {
            this.iZf.setVisibility(0);
        } else {
            this.iZf.setVisibility(8);
        }
    }
}
