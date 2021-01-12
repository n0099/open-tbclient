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
import com.baidu.adp.base.e;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes7.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel fle;
    private AntiHelper.a jEI;
    private ViewGroup kyA;
    private View kyB;
    private boolean kyC;
    private com.baidu.tbadk.core.dialog.a kyD;
    private RecommendForumInfo kyc;
    private ForumDetailActivity kyj;
    private ViewGroup kyx;
    private TextView kyy;
    private ImageView kyz;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.kyC = false;
        this.jEI = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kyC = false;
        this.jEI = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.kyx = (ViewGroup) findViewById(R.id.fn_care_box);
        this.kyy = (TextView) findViewById(R.id.fn_care_btn);
        this.kyz = (ImageView) findViewById(R.id.icon_brief_care);
        this.kyA = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.kyB = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.kyj = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.kyC = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.kyc = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            sG(recommendForumInfo.is_like.intValue() == 1);
            this.kyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.kyA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.kyC) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.bnj())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.kyj.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.kyx.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.kyC);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.bnj())) {
                    TiebaStatic.eventStat(this.kyj.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.kyC);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sF(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        ao.setViewTextColor(textView, R.color.CAM_X0111);
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
            this.kyj.sC(true);
        } else {
            this.kyj.sC(false);
        }
        this.kyj.setSwitch(z);
        this.kyj.sD(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.fle == null) {
            this.fle = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.fle.setFrom("detail_follow");
        this.fle.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (ItemFootNavView.this.fle.getErrorCode() == 22) {
                    ItemFootNavView.this.sF(true);
                    ItemFootNavView.this.sG(true);
                } else if (!AntiHelper.bQ(ItemFootNavView.this.fle.getErrorCode(), ItemFootNavView.this.fle.getErrorString())) {
                    if (ItemFootNavView.this.fle.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.fle.getErrorString());
                        return;
                    }
                    w wVar = (w) obj;
                    if (wVar != null) {
                        if (wVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), wVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqk();
                            return;
                        } else if (!AntiHelper.Jt(wVar.getErrorCode())) {
                            ItemFootNavView.this.sF(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.kyc.forum_name);
                            ItemFootNavView.this.sG(true);
                            wVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.fle.getBlockPopInfoData(), ItemFootNavView.this.jEI);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.fle.getBlockPopInfoData(), ItemFootNavView.this.jEI) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_LIKE_BAR));
                }
            }
        });
        this.fle.gq(this.kyc.forum_name, String.valueOf(this.kyc.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.kyD == null) {
            this.kyD = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.kyD.nu(R.string.forum_info_unlike_msg);
            this.kyD.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.kyD.dismiss();
                    ae aeVar = new ae();
                    aeVar.setFrom(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                    aeVar.a(new ae.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void C(String str, long j) {
                            ItemFootNavView.this.sF(false);
                            ItemFootNavView.this.sG(false);
                            if (ItemFootNavView.this.kyc != null && ItemFootNavView.this.kyc.forum_id.longValue() != 0) {
                                w wVar = new w();
                                wVar.setFid(j + "");
                                wVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, ItemFootNavView.this.kyc.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void D(String str, long j) {
                            if (j == 3250013) {
                                if (at.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqk();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    aeVar.P(ItemFootNavView.this.kyc.forum_name, ItemFootNavView.this.kyc.forum_id.longValue());
                }
            });
            this.kyD.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.kyD.dismiss();
                }
            });
            this.kyD.jE(true);
        }
        this.kyD.b(baseActivity.getPageContext()).bqe();
    }

    public void sG(boolean z) {
        int i;
        if (z) {
            ao.setImageResource(this.kyz, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.kyx.setTag(0);
        } else {
            ao.setImageResource(this.kyz, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.kyx.setTag(1);
        }
        this.kyy.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void sH(boolean z) {
        if (z) {
            this.kyB.setVisibility(0);
        } else {
            this.kyB.setVisibility(8);
        }
    }
}
