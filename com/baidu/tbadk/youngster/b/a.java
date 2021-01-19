package com.baidu.tbadk.youngster.b;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.YoungsterIntroduceActivityConfig;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.view.YoungsterFrsDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import tbclient.FrsPage.TipInfo;
/* loaded from: classes.dex */
public class a {
    public static void a(f<?> fVar, TipInfo tipInfo, String str, String str2, String str3) {
        if (fVar != null && tipInfo != null && !StringUtils.isNull(tipInfo.tip_pop_title) && !StringUtils.isNull(tipInfo.tip_pop)) {
            b bVar = new b(str, str2);
            if (a(tipInfo.tip_interval, bVar)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fVar.getPageActivity());
                aVar.Ac(tipInfo.tip_pop_title);
                aVar.setTitleShowCenter(true);
                aVar.setMessageShowCenter(true);
                aVar.Ad(tipInfo.tip_pop);
                aVar.a(str3, new a.b() { // from class: com.baidu.tbadk.youngster.b.a.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        com.baidu.tbadk.core.dialog.a.this.dismiss();
                    }
                });
                aVar.b(fVar).bqe();
                bVar.eK(System.currentTimeMillis());
            }
        }
    }

    private static boolean a(String str, b bVar) {
        int bIK;
        long bIJ;
        if (StringUtils.isNull(str)) {
            return false;
        }
        String[] split = str.split(",");
        if (bVar == null) {
            bIK = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_youngster_frs_showed_times", 0);
        } else {
            bIK = bVar.bIK();
        }
        if (bVar == null) {
            bIJ = com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_youngster_frs_dialog_show_time", 0L);
        } else {
            bIJ = bVar.bIJ();
        }
        int min = Math.min(bIK, split.length) - 1;
        if (min < 0 || min >= split.length) {
            return true;
        }
        return System.currentTimeMillis() - bIJ > ((long) com.baidu.adp.lib.f.b.toInt(split[min], 0)) * 86400000;
    }

    public static boolean a(TbPageContext<?> tbPageContext, AntiData antiData, int i) {
        if (antiData == null || !antiData.isSexyForum()) {
            return false;
        }
        if (c.bIM()) {
            c(tbPageContext, i);
            return true;
        } else if (DN(antiData.getTeenModeInterval())) {
            d(tbPageContext, i);
            return true;
        } else {
            return false;
        }
    }

    private static boolean DN(String str) {
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_youngster_frs_dialog_no_tip_again", false) || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        return a(str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final TbPageContext<?> tbPageContext, final int i) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        YoungsterFrsDialogView youngsterFrsDialogView = new YoungsterFrsDialogView(tbPageContext.getPageActivity());
        youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_close_title, new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.b.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(TbPageContext.this.getPageActivity());
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
            }
        });
        youngsterFrsDialogView.setRightOnClickListener(R.string.back, new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921486));
                com.baidu.tbadk.core.dialog.a.this.dismiss();
                tbPageContext.getPageActivity().finish();
            }
        });
        youngsterFrsDialogView.setNoTipAgainViewVisible(false);
        youngsterFrsDialogView.setTxtYoungsterDialogTitleText(R.string.youngster_open_title);
        youngsterFrsDialogView.setTxtYoungsterDialogContentText(R.string.youngster_dialog_close_message);
        youngsterFrsDialogView.setYoungsterDialogGroupMarginTop(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds95));
        aVar.br(youngsterFrsDialogView);
        aVar.nx(5);
        aVar.jD(false);
        aVar.b(tbPageContext).bqe();
        CustomMessageListener customMessageListener = new CustomMessageListener(2921484) { // from class: com.baidu.tbadk.youngster.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i2;
                Object data = customResponsedMessage.getData();
                if (!(data instanceof Integer)) {
                    i2 = 0;
                } else {
                    i2 = ((Integer) data).intValue();
                }
                switch (i2) {
                    case 3:
                        aVar.dismiss();
                        new BdTopToast(tbPageContext.getPageActivity(), 2000).yS(true).TQ(tbPageContext.getPageActivity().getString(R.string.youngster_close_title)).aR((ViewGroup) tbPageContext.getPageActivity().findViewById(i));
                        return;
                    default:
                        return;
                }
            }
        };
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            customMessageListener.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
        } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
            customMessageListener.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
        }
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    private static void d(final TbPageContext<?> tbPageContext, final int i) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        final YoungsterFrsDialogView youngsterFrsDialogView = new YoungsterFrsDialogView(tbPageContext.getPageActivity());
        youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_open_title, new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.b.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_youngster_frs_dialog_no_tip_again", YoungsterFrsDialogView.this.bqc());
                YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(tbPageContext.getPageActivity());
                youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterIntroduceActivityConfig));
            }
        });
        youngsterFrsDialogView.setRightOnClickListener(R.string.youngster_dialog_negative_button, new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.b.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("key_youngster_frs_dialog_no_tip_again", YoungsterFrsDialogView.this.bqc());
                new BdTopToast(tbPageContext.getPageActivity(), 2000).yS(true).TQ(tbPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aR((ViewGroup) tbPageContext.getPageActivity().findViewById(i));
                aVar.dismiss();
            }
        });
        youngsterFrsDialogView.setNoTipAgainViewVisible(true);
        youngsterFrsDialogView.setTxtYoungsterDialogTitleText(R.string.youngster_setting);
        youngsterFrsDialogView.setTxtYoungsterDialogContentText(R.string.youngster_dialog_message);
        youngsterFrsDialogView.setYoungsterDialogGroupMarginTop(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds65));
        aVar.br(youngsterFrsDialogView);
        aVar.nx(5);
        aVar.jD(false);
        aVar.b(tbPageContext).bqe();
        com.baidu.tbadk.core.sharedPref.b.brx().putLong("key_youngster_frs_dialog_show_time", System.currentTimeMillis());
        int i2 = com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_youngster_frs_showed_times", 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_youngster_frs_showed_times", i2 <= 2 ? i2 : 2);
        CustomMessageListener customMessageListener = new CustomMessageListener(2921487) { // from class: com.baidu.tbadk.youngster.b.a.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aVar.dismiss();
                a.c(tbPageContext, i);
            }
        };
        if (tbPageContext.getPageActivity() instanceof BaseActivity) {
            customMessageListener.setTag(((BaseActivity) tbPageContext.getPageActivity()).getUniqueId());
        } else if (tbPageContext.getPageActivity() instanceof BaseFragmentActivity) {
            customMessageListener.setTag(((BaseFragmentActivity) tbPageContext.getPageActivity()).getUniqueId());
        }
        MessageManager.getInstance().registerListener(customMessageListener);
    }
}
