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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ac;
import com.baidu.tieba.tbadkCore.u;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import tbclient.RecommendForumInfo;
/* loaded from: classes13.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel dKs;
    private AntiHelper.a hwY;
    private RecommendForumInfo ijU;
    private ForumDetailActivity ikb;
    private ViewGroup ikp;
    private TextView ikq;
    private ImageView ikr;
    private ViewGroup iks;
    private View ikt;
    private boolean iku;
    private com.baidu.tbadk.core.dialog.a ikv;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.iku = false;
        this.hwY = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iku = false;
        this.hwY = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.ikp = (ViewGroup) findViewById(R.id.fn_care_box);
        this.ikq = (TextView) findViewById(R.id.fn_care_btn);
        this.ikr = (ImageView) findViewById(R.id.icon_brief_care);
        this.iks = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.ikt = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.ikb = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.iku = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.ijU = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            oG(recommendForumInfo.is_like.intValue() == 1);
            this.ikp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.iks.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.iku) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aKo())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.ikb.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.ikp.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.iku);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.aKo())) {
                    TiebaStatic.eventStat(this.ikb.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.iku);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        am.setViewTextColor(textView, (int) R.color.cp_cont_g);
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
            this.ikb.oC(true);
        } else {
            this.ikb.oC(false);
        }
        this.ikb.setSwitch(z);
        this.ikb.oD(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.dKs == null) {
            this.dKs = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.dKs.setFrom("detail_follow");
        this.dKs.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (ItemFootNavView.this.dKs.getErrorCode() == 22) {
                    ItemFootNavView.this.oF(true);
                    ItemFootNavView.this.oG(true);
                } else if (!AntiHelper.bq(ItemFootNavView.this.dKs.getErrorCode(), ItemFootNavView.this.dKs.getErrorString())) {
                    if (ItemFootNavView.this.dKs.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.dKs.getErrorString());
                        return;
                    }
                    u uVar = (u) obj;
                    if (uVar != null) {
                        if (uVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), uVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMX();
                            return;
                        } else if (!AntiHelper.Dp(uVar.getErrorCode())) {
                            ItemFootNavView.this.oF(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.ijU.forum_name);
                            ItemFootNavView.this.oG(true);
                            uVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.dKs.getBlockPopInfoData(), ItemFootNavView.this.hwY);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.dKs.getBlockPopInfoData(), ItemFootNavView.this.hwY) != null) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_LIKE_BAR));
                }
            }
        });
        this.dKs.eP(this.ijU.forum_name, String.valueOf(this.ijU.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.ikv == null) {
            this.ikv = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.ikv.kd(R.string.forum_info_unlike_msg);
            this.ikv.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.ikv.dismiss();
                    ac acVar = new ac();
                    acVar.setFrom(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                    acVar.a(new ac.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void A(String str, long j) {
                            ItemFootNavView.this.oF(false);
                            ItemFootNavView.this.oG(false);
                            if (ItemFootNavView.this.ijU != null && ItemFootNavView.this.ijU.forum_id.longValue() != 0) {
                                u uVar = new u();
                                uVar.setFid(j + "");
                                uVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, uVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, ItemFootNavView.this.ijU.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.ac.a
                        public void B(String str, long j) {
                            if (j == 3250013) {
                                if (aq.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).aMX();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    acVar.L(ItemFootNavView.this.ijU.forum_name, ItemFootNavView.this.ijU.forum_id.longValue());
                }
            });
            this.ikv.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.ikv.dismiss();
                }
            });
            this.ikv.gF(true);
        }
        this.ikv.b(baseActivity.getPageContext()).aMS();
    }

    public void oG(boolean z) {
        int i;
        if (z) {
            am.setImageResource(this.ikr, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.ikp.setTag(0);
        } else {
            am.setImageResource(this.ikr, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.ikp.setTag(1);
        }
        this.ikq.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void oH(boolean z) {
        if (z) {
            this.ikt.setVisibility(0);
        } else {
            this.ikt.setVisibility(8);
        }
    }
}
