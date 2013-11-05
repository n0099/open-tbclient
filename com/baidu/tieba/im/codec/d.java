package com.baidu.tieba.im.codec;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponsedMessage;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class d implements n<com.baidu.tieba.im.codec.a.c> {

    /* renamed from: a  reason: collision with root package name */
    Map<String, e> f1479a = new HashMap();
    private final Class<? extends Message> b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.LinkedList, java.lang.Object, com.baidu.tieba.im.codec.q, int] */
    @Override // com.baidu.tieba.im.codec.n
    public /* bridge */ /* synthetic */ void a(LinkedList linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        a2((LinkedList<Message>) linkedList, cVar, qVar, i);
    }

    public d(Class<? extends Message> cls) {
        this.b = cls;
        a(cls);
    }

    protected void a(Class<? extends Message> cls) {
        Method[] methods;
        h a2;
        String str;
        for (Method method : cls.getMethods()) {
            if (Modifier.isPublic(method.getModifiers()) && !Modifier.isStatic(method.getModifiers()) && Void.TYPE.equals(method.getReturnType()) && method.getParameterTypes().length == 1 && (a2 = j.a(method.getParameterTypes()[0].getName())) != null) {
                String name = method.getName();
                if (name.startsWith("set") && name.length() >= 4) {
                    String substring = name.substring(3);
                    if (substring.length() == 1) {
                        str = substring.toLowerCase();
                    } else {
                        str = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                    }
                    e eVar = new e();
                    eVar.f1480a = method;
                    eVar.b = a2;
                    this.f1479a.put(str, eVar);
                }
            }
        }
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void a2(LinkedList<Message> linkedList, com.baidu.tieba.im.codec.a.c cVar, q qVar, int i) {
        Message newInstance = this.b.newInstance();
        newInstance.setCmd(i);
        if (newInstance instanceof ResponsedMessage) {
            ResponsedMessage responsedMessage = (ResponsedMessage) newInstance;
            linkedList.add(newInstance);
            responsedMessage.setErrorInfo(qVar);
            if (responsedMessage.hasError()) {
                return;
            }
        }
        if (cVar != null) {
            for (Map.Entry<String, e> entry : this.f1479a.entrySet()) {
                e value = entry.getValue();
                String a2 = cVar.a(entry.getKey());
                if (a2 != null) {
                    value.f1480a.invoke(newInstance, value.b.a(a2));
                }
            }
        }
    }
}
