package com.baidu.tieba.emotion.editortool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionIntefaceStatic {

    /* loaded from: classes4.dex */
    public static class a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.a.o0.i0.b.e.i().q();
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof EditorTools)) {
                return;
            }
            EditorTools editorTools = (EditorTools) customResponsedMessage.getData();
            int indexOf = editorTools.getCollectTools().indexOf(5);
            if (indexOf != -1) {
                if (editorTools.s()) {
                    editorTools.d(new d.a.o0.i0.b.a(editorTools.getContext(), indexOf + 1, false));
                } else {
                    editorTools.d(new d.a.o0.i0.b.a(editorTools.getContext(), indexOf + 1));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof List)) {
                return;
            }
            for (d.a.n0.w.p.a aVar : (List) customResponsedMessage.getData()) {
                d.a.o0.i0.b.e.i().p(aVar);
            }
            d.a.o0.i0.b.e.i().q();
            MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            d.a.o0.i0.b.e.i().q();
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            if (customMessage == null || !(customMessage instanceof RequestStaticEmotionMessage)) {
                return null;
            }
            RequestStaticEmotionMessage requestStaticEmotionMessage = (RequestStaticEmotionMessage) customMessage;
            return new CustomResponsedMessage<>(customMessage.getCmd(), d.a.o0.i0.b.e.i().n(requestStaticEmotionMessage.getGroupID(), requestStaticEmotionMessage.getSharpText()));
        }
    }

    /* loaded from: classes4.dex */
    public static class f implements CustomMessageTask.CustomRunnable<String> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            if (customMessage == null) {
                return null;
            }
            return new CustomResponsedMessage<>(2004608, Boolean.valueOf(d.a.o0.i0.b.e.i().j(customMessage.getData())));
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements CustomMessageTask.CustomRunnable<String> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
            if (customMessage == null) {
                return null;
            }
            return new CustomResponsedMessage<>(2004609, Boolean.valueOf(d.a.o0.i0.b.e.i().k(customMessage.getData())));
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof List)) {
                return;
            }
            ((List) customResponsedMessage.getData()).add(d.a.o0.i0.b.d.f());
        }
    }

    static {
        d.a.c.e.l.d.h().o(20, new d.a.o0.i0.a.a());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        TbadkCoreApplication.getInst().registerReceiver(new a(), intentFilter);
        b bVar = new b(2010044);
        c cVar = new c(2004602);
        CustomMessageTask customMessageTask = new CustomMessageTask(2004603, new d());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2004604, new e());
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2004608, new f());
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2004609, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerTask(customMessageTask3);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask4);
        MessageManager.getInstance().registerListener(bVar);
        cVar.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(cVar);
        MessageManager.getInstance().registerListener(new h(2004602));
    }
}
