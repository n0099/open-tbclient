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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ad;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.v;
import tbclient.RecommendForumInfo;
/* loaded from: classes25.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel ezi;
    private AntiHelper.a iBu;
    private ViewGroup jwK;
    private TextView jwL;
    private ImageView jwM;
    private ViewGroup jwN;
    private View jwO;
    private boolean jwP;
    private com.baidu.tbadk.core.dialog.a jwQ;
    private RecommendForumInfo jwp;
    private ForumDetailActivity jww;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.jwP = false;
        this.iBu = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jwP = false;
        this.iBu = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.jwK = (ViewGroup) findViewById(R.id.fn_care_box);
        this.jwL = (TextView) findViewById(R.id.fn_care_btn);
        this.jwM = (ImageView) findViewById(R.id.icon_brief_care);
        this.jwN = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.jwO = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.jww = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.jwP = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.jwp = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            qJ(recommendForumInfo.is_like.intValue() == 1);
            this.jwK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.jwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.jwP) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.bfk())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.jww.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.jwK.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.jwP);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.bfk())) {
                    TiebaStatic.eventStat(this.jww.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.jwP);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qI(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        ap.setViewTextColor(textView, R.color.cp_cont_g);
        if (z) {
            imageView.setImageDrawable(ap.getDrawable(R.drawable.icon_tips_attention_ok));
            textView.setText(R.string.attention);
        } else {
            imageView.setImageDrawable(ap.getDrawable(R.drawable.icon_tips_attention_cancel));
            textView.setText(R.string.unfollow_title);
        }
        Toast toast = new Toast(this.mContext);
        toast.setView(inflate);
        toast.setGravity(17, 0, 0);
        toast.setDuration(1000);
        toast.show();
        if (z) {
            this.jww.qF(true);
        } else {
            this.jww.qF(false);
        }
        this.jww.setSwitch(z);
        this.jww.qG(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.ezi == null) {
            this.ezi = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.ezi.setFrom("detail_follow");
        this.ezi.setLoadDataCallBack(new d() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (ItemFootNavView.this.ezi.getErrorCode() == 22) {
                    ItemFootNavView.this.qI(true);
                    ItemFootNavView.this.qJ(true);
                } else if (!AntiHelper.bC(ItemFootNavView.this.ezi.getErrorCode(), ItemFootNavView.this.ezi.getErrorString())) {
                    if (ItemFootNavView.this.ezi.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.ezi.getErrorString());
                        return;
                    }
                    v vVar = (v) obj;
                    if (vVar != null) {
                        if (vVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), vVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).big();
                            return;
                        } else if (!AntiHelper.IA(vVar.getErrorCode())) {
                            ItemFootNavView.this.qI(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.jwp.forum_name);
                            ItemFootNavView.this.qJ(true);
                            vVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.ezi.getBlockPopInfoData(), ItemFootNavView.this.iBu);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.ezi.getBlockPopInfoData(), ItemFootNavView.this.iBu) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_LIKE_BAR));
                }
            }
        });
        this.ezi.gd(this.jwp.forum_name, String.valueOf(this.jwp.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.jwQ == null) {
            this.jwQ = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.jwQ.nE(R.string.forum_info_unlike_msg);
            this.jwQ.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.jwQ.dismiss();
                    ad adVar = new ad();
                    adVar.setFrom(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                    adVar.a(new ad.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void z(String str, long j) {
                            ItemFootNavView.this.qI(false);
                            ItemFootNavView.this.qJ(false);
                            if (ItemFootNavView.this.jwp != null && ItemFootNavView.this.jwp.forum_id.longValue() != 0) {
                                v vVar = new v();
                                vVar.setFid(j + "");
                                vVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, vVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, ItemFootNavView.this.jwp.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.ad.a
                        public void A(String str, long j) {
                            if (j == 3250013) {
                                if (at.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).big();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    adVar.L(ItemFootNavView.this.jwp.forum_name, ItemFootNavView.this.jwp.forum_id.longValue());
                }
            });
            this.jwQ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.jwQ.dismiss();
                }
            });
            this.jwQ.ie(true);
        }
        this.jwQ.b(baseActivity.getPageContext()).bia();
    }

    public void qJ(boolean z) {
        int i;
        if (z) {
            ap.setImageResource(this.jwM, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.jwK.setTag(0);
        } else {
            ap.setImageResource(this.jwM, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.jwK.setTag(1);
        }
        this.jwL.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void qK(boolean z) {
        if (z) {
            this.jwO.setVisibility(0);
        } else {
            this.jwO.setVisibility(8);
        }
    }
}
