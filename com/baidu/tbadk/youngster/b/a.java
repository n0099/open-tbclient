package com.baidu.tbadk.youngster.b;

import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.view.YoungsterFrsDialogView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BdTopToast;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class a {
    public static void a(TbPageContext<?> tbPageContext, AntiData antiData, int i) {
        if (antiData != null && antiData.isSexyForum()) {
            if (b.bzf()) {
                c(tbPageContext, i);
            } else if (CX(antiData.getTeenModeInterval())) {
                d(tbPageContext, i);
            }
        }
    }

    private static boolean CX(String str) {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_youngster_frs_dialog_no_tip_again", false) || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        return System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_youngster_frs_dialog_show_time", 0L) >= k(CY(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final TbPageContext<?> tbPageContext, final int i) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        YoungsterFrsDialogView youngsterFrsDialogView = new YoungsterFrsDialogView(tbPageContext.getPageActivity());
        youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_close_title, new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.b.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(TbPageContext.this.getPageActivity());
                youngsterPasswordActivityConfig.setYoungsterPasswordPageType(3);
                youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
            }
        });
        youngsterFrsDialogView.setRightOnClickListener(R.string.back, new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.b.a.2
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
        aVar.aX(youngsterFrsDialogView);
        aVar.nw(5);
        aVar.ig(false);
        aVar.b(tbPageContext).bhg();
        CustomMessageListener customMessageListener = new CustomMessageListener(2921484) { // from class: com.baidu.tbadk.youngster.b.a.3
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
                        new BdTopToast(tbPageContext.getPageActivity(), 2000).wU(true).Sp(tbPageContext.getPageActivity().getString(R.string.youngster_close_title)).aE((ViewGroup) tbPageContext.getPageActivity().findViewById(i));
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
        youngsterFrsDialogView.setLeftOnClickListener(R.string.youngster_settings_open_title, new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.b.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_youngster_frs_dialog_no_tip_again", YoungsterFrsDialogView.this.bhe());
                YoungsterIntroduceActivityConfig youngsterIntroduceActivityConfig = new YoungsterIntroduceActivityConfig(tbPageContext.getPageActivity());
                youngsterIntroduceActivityConfig.setKeyYoungsterPasswordFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterIntroduceActivityConfig));
            }
        });
        youngsterFrsDialogView.setRightOnClickListener(R.string.youngster_dialog_negative_button, new View.OnClickListener() { // from class: com.baidu.tbadk.youngster.b.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tbadk.core.sharedPref.b.bik().putBoolean("key_youngster_frs_dialog_no_tip_again", YoungsterFrsDialogView.this.bhe());
                new BdTopToast(tbPageContext.getPageActivity(), 2000).wU(true).Sp(tbPageContext.getPageActivity().getString(R.string.youngster_frs_top_toast)).aE((ViewGroup) tbPageContext.getPageActivity().findViewById(i));
                aVar.dismiss();
            }
        });
        youngsterFrsDialogView.setNoTipAgainViewVisible(true);
        youngsterFrsDialogView.setTxtYoungsterDialogTitleText(R.string.youngster_setting);
        youngsterFrsDialogView.setTxtYoungsterDialogContentText(R.string.youngster_dialog_message);
        youngsterFrsDialogView.setYoungsterDialogGroupMarginTop(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds65));
        aVar.aX(youngsterFrsDialogView);
        aVar.nw(5);
        aVar.ig(false);
        aVar.b(tbPageContext).bhg();
        com.baidu.tbadk.core.sharedPref.b.bik().putLong("key_youngster_frs_dialog_show_time", System.currentTimeMillis());
        int i2 = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_youngster_frs_showed_times", 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_youngster_frs_showed_times", i2 <= 2 ? i2 : 2);
        CustomMessageListener customMessageListener = new CustomMessageListener(2921487) { // from class: com.baidu.tbadk.youngster.b.a.6
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

    private static int[] CY(String str) {
        int[] iArr = {0, 0, 0};
        if (!StringUtils.isNull(str)) {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 2) {
                for (int i = 0; i < 3; i++) {
                    iArr[i] = com.baidu.adp.lib.f.b.toInt(split[i], 0);
                }
            }
        }
        return iArr;
    }

    private static long k(int[] iArr) {
        int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_youngster_frs_showed_times", 0);
        if (iArr.length <= 2 || i < 0 || i >= 3 || iArr[i] <= 1) {
            return 0L;
        }
        return iArr[i] * 86400000;
    }
}
