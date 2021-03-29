package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class ModelHelper {
    public static volatile ModelHelper sInstance;
    public IUpdatesModel mUpdatesModel;
    public IValidateModel mValidateModel;

    public ModelHelper() {
        init();
    }

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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001299, IValidateModel.class);
        if (runTask != null) {
            this.mValidateModel = (IValidateModel) runTask.getData();
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001298, IUpdatesModel.class);
        if (runTask2 != null) {
            this.mUpdatesModel = (IUpdatesModel) runTask2.getData();
        }
    }

    public IUpdatesModel getUpdatasModel() {
        return this.mUpdatesModel;
    }

    public IValidateModel getValidateModel() {
        return this.mValidateModel;
    }
}
