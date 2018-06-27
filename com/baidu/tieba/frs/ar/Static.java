package com.baidu.tieba.frs.ar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsArActivityConfig;
import com.baidu.tbadk.core.sharedPref.b;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.ar.view.FrsARAnimView;
import com.baidu.tieba.frs.ar.view.FrsAREntryView;
import java.util.Calendar;
import tbclient.ForumArIno;
/* loaded from: classes3.dex */
public class Static {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsArActivityConfig.class, ARActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2921326, new CustomMessageTask.CustomRunnable<FrsFragment>() { // from class: com.baidu.tieba.frs.ar.Static.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<FrsFragment> customMessage) {
                FrsARAnimView frsARAnimView = null;
                boolean z = true;
                if (customMessage == null || customMessage.getData() == null || customMessage.getData() == null || customMessage.getData().atZ() == null || customMessage.getData().atZ().dpj == null) {
                    return null;
                }
                ForumArIno forumArIno = customMessage.getData().atZ().dpj;
                if (forumArIno._switch.intValue() != 0) {
                    FrsAREntryView frsAREntryView = new FrsAREntryView(customMessage.getData().getPageContext().getPageActivity());
                    frsAREntryView.setForumArIno(forumArIno);
                    if (customMessage.getData().atZ().baT() != null) {
                        frsAREntryView.setForumName(customMessage.getData().atZ().baT().getName());
                    }
                    frsAREntryView.avP();
                    long j = b.getInstance().getLong("frs_ar_big_anim_show_time", 0L);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(j);
                    Calendar calendar2 = Calendar.getInstance();
                    int i = calendar.get(6);
                    int i2 = calendar.get(1);
                    int i3 = calendar2.get(6);
                    if (i2 == calendar2.get(1) && i == i3) {
                        z = false;
                    }
                    if (z) {
                        frsARAnimView = new FrsARAnimView(customMessage.getData().getPageContext().getPageActivity());
                        frsARAnimView.setBdUniqueId(customMessage.getData().getUniqueId());
                        frsARAnimView.startAnim();
                        b.getInstance().putLong("frs_ar_big_anim_show_time", calendar2.getTimeInMillis());
                    }
                    ViewGroup adP = customMessage.getData().atI().adP();
                    if (adP instanceof RelativeLayout) {
                        RelativeLayout relativeLayout = (RelativeLayout) adP;
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams.addRule(11);
                        layoutParams.addRule(12);
                        layoutParams.bottomMargin = 100;
                        layoutParams.rightMargin = 30;
                        relativeLayout.addView(frsAREntryView, layoutParams);
                        if (z) {
                            relativeLayout.addView(frsARAnimView, new RelativeLayout.LayoutParams(-1, -1));
                        }
                    } else if (adP instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) adP;
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                        layoutParams2.gravity = 85;
                        layoutParams2.bottomMargin = 100;
                        layoutParams2.rightMargin = 30;
                        frameLayout.addView(frsAREntryView, layoutParams2);
                        if (z) {
                            frameLayout.addView(frsARAnimView, new FrameLayout.LayoutParams(-1, -1));
                        }
                    }
                    CustomResponsedMessage<?> customResponsedMessage = new CustomResponsedMessage<>(2921326);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    return customResponsedMessage;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
