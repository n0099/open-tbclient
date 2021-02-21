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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.switchs.BarDetailForDirSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.ae;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
import tbclient.RecommendForumInfo;
/* loaded from: classes8.dex */
public class ItemFootNavView extends LinearLayout {
    private LikeModel fnw;
    private AntiHelper.a jKA;
    private ForumDetailActivity kGD;
    private ViewGroup kGR;
    private TextView kGS;
    private ImageView kGT;
    private ViewGroup kGU;
    private View kGV;
    private boolean kGW;
    private com.baidu.tbadk.core.dialog.a kGX;
    private RecommendForumInfo kGw;
    private Context mContext;

    public ItemFootNavView(Context context) {
        super(context);
        this.kGW = false;
        this.jKA = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public ItemFootNavView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kGW = false;
        this.jKA = new AntiHelper.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
            }
        };
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.forum_detail_foot_nav, (ViewGroup) this, true);
        setOrientation(1);
        setVisibility(8);
        this.kGR = (ViewGroup) findViewById(R.id.fn_care_box);
        this.kGS = (TextView) findViewById(R.id.fn_care_btn);
        this.kGT = (ImageView) findViewById(R.id.icon_brief_care);
        this.kGU = (ViewGroup) findViewById(R.id.fn_enter_box);
        this.kGV = findViewById(R.id.foot_line);
    }

    public void setData(RecommendForumInfo recommendForumInfo, final ForumDetailActivity forumDetailActivity) {
        this.kGD = forumDetailActivity;
        if (recommendForumInfo != null) {
            this.kGW = ForumDetailActivityConfig.isFromFrs(forumDetailActivity.getIntent().getStringExtra("from_type"));
            this.kGw = recommendForumInfo;
            final String str = recommendForumInfo.forum_name;
            sT(recommendForumInfo.is_like.intValue() == 1);
            this.kGR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ItemFootNavView.this.d(forumDetailActivity);
                }
            });
            this.kGU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.eventStat(ItemFootNavView.this.mContext, "detail_enter_forum", "click", 1, new Object[0]);
                    if (ItemFootNavView.this.kGW) {
                        forumDetailActivity.finish();
                        return;
                    }
                    forumDetailActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(forumDetailActivity.getPageContext().getPageActivity()).createNormalCfg(str, BarDetailForDirSwitch.BAR_DETAIL_DIR)));
                    if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.bnC())) {
                        TiebaStatic.eventStat(ItemFootNavView.this.kGD.getPageContext().getPageActivity(), "squae_introduce_entry", "click", 1, new Object[0]);
                    }
                }
            });
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ForumDetailActivity forumDetailActivity) {
        if (forumDetailActivity == null || forumDetailActivity.checkUpIsLogin()) {
            int intValue = ((Integer) this.kGR.getTag()).intValue();
            if (intValue == 0) {
                a((BaseActivity<ForumDetailActivity>) forumDetailActivity, this.kGW);
            } else if (intValue == 1) {
                if (forumDetailActivity != null && ForumDetailActivityConfig.FromType.BAR_SQUARE.toString().equals(forumDetailActivity.bnC())) {
                    TiebaStatic.eventStat(this.kGD.getPageContext().getPageActivity(), "squae_introduce_focus", "click", 1, new Object[0]);
                }
                a(forumDetailActivity, this.kGW);
            }
            TiebaStatic.eventStat(this.mContext, intValue == 1 ? "detail_care_add" : "detail_care_cancel", "click", 1, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sS(boolean z) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.forum_detail_attention_toast, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.attention_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.attention_title);
        ap.setViewTextColor(textView, R.color.CAM_X0111);
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
            this.kGD.sP(true);
        } else {
            this.kGD.sP(false);
        }
        this.kGD.setSwitch(z);
        this.kGD.sQ(z);
    }

    private void a(final ForumDetailActivity forumDetailActivity, boolean z) {
        if (this.fnw == null) {
            this.fnw = new LikeModel(forumDetailActivity.getPageContext());
        }
        this.fnw.setFrom("detail_follow");
        this.fnw.setLoadDataCallBack(new e() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.4
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (ItemFootNavView.this.fnw.getErrorCode() == 22) {
                    ItemFootNavView.this.sS(true);
                    ItemFootNavView.this.sT(true);
                } else if (!AntiHelper.bX(ItemFootNavView.this.fnw.getErrorCode(), ItemFootNavView.this.fnw.getErrorString())) {
                    if (ItemFootNavView.this.fnw.getErrorCode() != 0) {
                        forumDetailActivity.showToast(ItemFootNavView.this.fnw.getErrorString());
                        return;
                    }
                    w wVar = (w) obj;
                    if (wVar != null) {
                        if (wVar.getErrorCode() == 3250013) {
                            BdToast.a(TbadkCoreApplication.getInst().getContext(), wVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqD();
                            return;
                        } else if (!AntiHelper.JN(wVar.getErrorCode())) {
                            ItemFootNavView.this.sS(true);
                            TbadkApplication.getInst().addLikeForum(ItemFootNavView.this.kGw.forum_name);
                            ItemFootNavView.this.sT(true);
                            wVar.setLike(1);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                            return;
                        } else {
                            AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.fnw.getBlockPopInfoData(), ItemFootNavView.this.jKA);
                            return;
                        }
                    }
                    forumDetailActivity.showToast(forumDetailActivity.getPageContext().getString(R.string.neterror));
                } else if (AntiHelper.a(forumDetailActivity.getPageContext().getPageActivity(), ItemFootNavView.this.fnw.getBlockPopInfoData(), ItemFootNavView.this.jKA) != null) {
                    TiebaStatic.log(new ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ap("obj_locate", ay.a.LOCATE_LIKE_BAR));
                }
            }
        });
        this.fnw.gy(this.kGw.forum_name, String.valueOf(this.kGw.forum_id));
    }

    private void a(final BaseActivity<ForumDetailActivity> baseActivity, boolean z) {
        if (this.kGX == null) {
            this.kGX = new com.baidu.tbadk.core.dialog.a(baseActivity.getPageContext().getPageActivity());
            this.kGX.nx(R.string.forum_info_unlike_msg);
            this.kGX.a(R.string.alert_yes_button, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.kGX.dismiss();
                    ae aeVar = new ae();
                    aeVar.setFrom(BarDetailForDirSwitch.BAR_DETAIL_DIR);
                    aeVar.a(new ae.a() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.5.1
                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void B(String str, long j) {
                            ItemFootNavView.this.sS(false);
                            ItemFootNavView.this.sT(false);
                            if (ItemFootNavView.this.kGw != null && ItemFootNavView.this.kGw.forum_id.longValue() != 0) {
                                w wVar = new w();
                                wVar.setFid(j + "");
                                wVar.setLike(0);
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, wVar));
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_CANCLE_LIKE_FRS, ItemFootNavView.this.kGw.forum_id + ""));
                            }
                        }

                        @Override // com.baidu.tieba.tbadkCore.ae.a
                        public void C(String str, long j) {
                            if (j == 3250013) {
                                if (au.isEmpty(str)) {
                                    str = TbadkCoreApplication.getInst().getContext().getString(R.string.anti_account_exception_appealing);
                                }
                                BdToast.a(TbadkCoreApplication.getInst().getContext(), str, R.drawable.icon_pure_toast_mistake40_svg, 3000, true).bqD();
                                return;
                            }
                            baseActivity.showToast(baseActivity.getPageContext().getString(R.string.unlike_failure));
                        }
                    });
                    aeVar.O(ItemFootNavView.this.kGw.forum_name, ItemFootNavView.this.kGw.forum_id.longValue());
                }
            });
            this.kGX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.forum.detail.ItemFootNavView.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ItemFootNavView.this.kGX.dismiss();
                }
            });
            this.kGX.jG(true);
        }
        this.kGX.b(baseActivity.getPageContext()).bqx();
    }

    public void sT(boolean z) {
        int i;
        if (z) {
            ap.setImageResource(this.kGT, R.drawable.icon_pop_pass);
            i = R.string.relate_forum_is_followed;
            this.kGR.setTag(0);
        } else {
            ap.setImageResource(this.kGT, R.drawable.icon_brief_attention);
            i = R.string.attention;
            this.kGR.setTag(1);
        }
        this.kGS.setText(this.mContext.getResources().getString(i));
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
    }

    public void e(ForumDetailActivity forumDetailActivity) {
    }

    public void sU(boolean z) {
        if (z) {
            this.kGV.setVisibility(0);
        } else {
            this.kGV.setVisibility(8);
        }
    }
}
