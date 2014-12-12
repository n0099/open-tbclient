package com.baidu.tieba.hao123;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.message.Hao123AddLikeMessage;
import com.baidu.tbadk.core.message.Hao123UpdateInitMessage;
import com.baidu.tbadk.core.message.Hao123UpdateMessage;
import com.baidu.tbadk.core.message.Hao123UpdateSignMessage;
import com.baidu.tbadk.core.message.a;
import com.baidu.tbadk.core.message.b;
import com.baidu.tieba.data.Hao123Data;
import com.baidu.tieba.model.Hao123Model;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class Hao123Static {
    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.hao123.Hao123Static.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2001241) {
                        if (customResponsedMessage instanceof Hao123UpdateMessage) {
                            new UpdateHao123CacheTask().execute(new Object[0]);
                        }
                    } else if (customResponsedMessage.getCmd() == 2001242) {
                        if ((customResponsedMessage instanceof Hao123AddLikeMessage) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof a)) {
                            new AddLikeHao123CacheTask((a) customResponsedMessage.getData()).execute(new Object[0]);
                        }
                    } else if (customResponsedMessage.getCmd() == 2001243) {
                        if ((customResponsedMessage instanceof Hao123UpdateSignMessage) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof b)) {
                            new UpdateSignHao123CacheTask((b) customResponsedMessage.getData()).execute(new Object[0]);
                        }
                    } else if (customResponsedMessage.getCmd() == 2001244 && (customResponsedMessage instanceof Hao123UpdateInitMessage)) {
                        new InitData(null).execute(new Void[0]);
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(2001241, customMessageListener);
        MessageManager.getInstance().registerListener(2001242, customMessageListener);
        MessageManager.getInstance().registerListener(2001243, customMessageListener);
        MessageManager.getInstance().registerListener(2001244, customMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class InitData extends BdAsyncTask<Void, Void, Void> {
        private InitData() {
        }

        /* synthetic */ InitData(InitData initData) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(Hao123Model.getHao123Cache())) {
                Hao123Model.setHao123Cache(Hao123Model.getHao123JosnStr(Hao123Model.parserLikeForumsProtoBuf(new ArrayList())));
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class UpdateHao123CacheTask extends BdAsyncTask<Object, Integer, Integer> {
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Object... objArr) {
            Hao123Static.updateHao123Cache();
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class AddLikeHao123CacheTask extends BdAsyncTask<Object, Integer, Integer> {
        a data;

        public AddLikeHao123CacheTask(a aVar) {
            this.data = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Object... objArr) {
            Hao123Model.addLikeData(this.data.Gb, this.data.forumName, this.data.level);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class UpdateSignHao123CacheTask extends BdAsyncTask<Object, Integer, Integer> {
        b data;

        public UpdateSignHao123CacheTask(b bVar) {
            this.data = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(Object... objArr) {
            Hao123Model.updateSign(this.data.Gb, this.data.Gc, this.data.Gd);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateHao123Cache() {
        String hao123Cache = Hao123Model.getHao123Cache();
        if (!TextUtils.isEmpty(hao123Cache)) {
            Hao123Data hao123Data = (Hao123Data) i.objectWithJsonStr(hao123Cache, Hao123Data.class);
            hao123Data.login = "no";
            Hao123Model.setHao123Cache(i.jsonStrWithObject(hao123Data));
            return;
        }
        Hao123Data hao123Data2 = new Hao123Data();
        hao123Data2.login = "no";
        Hao123Model.setHao123Cache(i.jsonStrWithObject(hao123Data2));
    }
}
