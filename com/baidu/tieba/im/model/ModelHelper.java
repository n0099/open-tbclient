package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class ModelHelper {
    private static volatile ModelHelper sInstance;
    private IUpdatesModel mUpdatesModel;
    private IValidateModel mValidateModel;

    public static ModelHelper getInstance() {
        if (sInstance == null) {
            synchronized (ModelHelper.class) {
                if (sInstance == null) {
                    sInstance = new ModelHelper();
                }
            }
        }
        return sInstance;
    }

    private void init() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VALIDATE_MODEL, IValidateModel.class);
        if (runTask != null) {
            this.mValidateModel = (IValidateModel) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_UPDATES_MODEL, IUpdatesModel.class);
        if (runTask2 != null) {
            this.mUpdatesModel = (IUpdatesModel) runTask2.getData();
        }
    }

    private ModelHelper() {
        init();
    }

    public IUpdatesModel getUpdatasModel() {
        return this.mUpdatesModel;
    }

    public IValidateModel getValidateModel() {
        return this.mValidateModel;
    }
}
