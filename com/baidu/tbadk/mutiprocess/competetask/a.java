package com.baidu.tbadk.mutiprocess.competetask;

import android.app.Activity;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskToastData;
import com.baidu.tbadk.BdToken.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.b;
/* loaded from: classes.dex */
public class a implements b<CompeteTaskEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(CompeteTaskEvent competeTaskEvent) {
        if (competeTaskEvent == null || competeTaskEvent.taskToastData == null) {
            return false;
        }
        CompleteTaskToastData completeTaskToastData = competeTaskEvent.taskToastData;
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof o) {
            ((o) currentActivity).onMissionCompleted(completeTaskToastData);
            return true;
        }
        return false;
    }
}
