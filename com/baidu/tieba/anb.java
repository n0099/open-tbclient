package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rmb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.monitor.SessionMonitorEngine;
import com.yy.transvod.player.log.TLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class anb implements rmb, Runnable {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] m;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public String b;
    public int c;
    public rmb.a d;
    public Object e;
    public Object f;
    public LinkedList<Message> g;
    public TreeMap<Long, Message> h;
    public LinkedList<Message> i;
    public TreeMap<Long, Message> j;
    public AtomicInteger k;
    public Thread l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622356, "Lcom/baidu/tieba/anb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622356, "Lcom/baidu/tieba/anb;");
                return;
            }
        }
        m = new String[]{"None", "Ready", "Running", "Paused", "Stopped"};
    }

    @Override // com.baidu.tieba.rmb
    public int getStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.k.get();
        }
        return invokeV.intValue;
    }

    public anb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = anb.class.getSimpleName();
        this.b = SessionMonitorEngine.PUBLIC_DATA_UNDIFNED;
        this.c = -2;
        this.d = null;
        this.e = new Object();
        this.f = new Object();
        this.g = new LinkedList<>();
        this.h = new TreeMap<>();
        this.i = new LinkedList<>();
        this.j = new TreeMap<>();
        this.k = new AtomicInteger(1);
        this.l = null;
        if (str != null) {
            this.b = str;
        }
        this.c = 0;
    }

    public static int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i > 19) {
                i = 19;
            } else if (i < -8) {
                i = -8;
            }
            return ((i - 19) * 9) / (-27);
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tieba.rmb
    public void b(rmb.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.d = aVar;
            if (aVar != null) {
                return;
            }
            throw new RuntimeException("mCallback is not set!");
        }
    }

    @Override // com.baidu.tieba.rmb
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (getStatus() == 1) {
                this.c = i;
                return;
            }
            throw new IllegalStateException("invalid state");
        }
    }

    @Override // com.baidu.tieba.rmb
    public boolean e(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, runnable)) == null) {
            Message obtain = Message.obtain((Handler) null, runnable);
            boolean sendMessage = sendMessage(obtain);
            try {
                obtain.recycle();
            } catch (IllegalStateException unused) {
                TLog.d(this.a, "message recycle error");
            }
            return sendMessage;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rmb
    public boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            return a(i, 0L);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.rmb
    public boolean sendMessage(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, message)) == null) {
            return i(message, 0L);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.rmb
    public void setName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.b = str;
        }
    }

    @Override // com.baidu.tieba.rmb
    public boolean a(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            return i(obtain, j);
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:4|5|(2:10|11)|15|50|19|20|21|22|11) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
        r4.printStackTrace();
        r4 = r7.a;
        com.yy.transvod.player.log.TLog.m(r4, r7.b + "stop thread, join exception");
     */
    @Override // com.baidu.tieba.rmb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                int i = this.k.get();
                if (i != 2 && i != 3) {
                    TLog.m(this.a, String.format("[%s] already stopped? mThreadStatus = %s", this.b, m[i]));
                }
                String str = this.a;
                TLog.h(str, this.b + "stop thread, status to 4");
                this.k.set(4);
                synchronized (this.f) {
                    this.f.notify();
                }
                int myTid = Process.myTid();
                String str2 = this.a;
                TLog.h(str2, this.b + "stop thread, join in");
                this.l.join();
                this.l = null;
                this.k.set(1);
                TLog.h(this.a, String.format("[%s] stop thread tid %d", this.b, Integer.valueOf(myTid)));
            }
        }
    }

    @Override // com.baidu.tieba.rmb
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.l != null) {
                TLog.m(this.a, "is alive already");
            } else if (this.d != null) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this) {
                    try {
                        this.k.set(2);
                        Thread thread = new Thread(this, this.b);
                        this.l = thread;
                        thread.setPriority(h(this.c));
                        this.l.start();
                        String str = this.a;
                        TLog.h(str, this.b + "  isAlive:" + this.l.isAlive());
                    } catch (Exception e) {
                        e.printStackTrace();
                        String str2 = this.a;
                        TLog.d(str2, this.b + " start thread, exception:" + e.getMessage());
                    }
                }
                StringBuilder sb = new StringBuilder();
                String str3 = this.b;
                if (str3 != null) {
                    sb.append(str3);
                }
                sb.append(" YYThread2 start cost:");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                TLog.m(this.a, sb.toString());
            } else {
                throw new RuntimeException("mCallback is null");
            }
        }
    }

    @Override // com.baidu.tieba.rmb
    public void g(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && this.k.get() == 2) {
            synchronized (this.f) {
                Iterator<Message> it = this.g.iterator();
                while (it.hasNext()) {
                    Message next = it.next();
                    if (next.what == i) {
                        try {
                            next.recycle();
                        } catch (IllegalStateException unused) {
                            TLog.d(this.a, "message recycle error");
                        }
                        it.remove();
                    }
                }
                for (Map.Entry<Long, Message> entry : this.h.entrySet()) {
                    if (entry.getValue().what == i) {
                        this.h.remove(entry.getKey());
                        try {
                            entry.getValue().recycle();
                        } catch (IllegalStateException unused2) {
                            TLog.d(this.a, "message recycle error");
                        }
                    }
                }
                synchronized (this.e) {
                    for (Map.Entry<Long, Message> entry2 : this.j.entrySet()) {
                        if (entry2.getValue().what == i) {
                            this.j.remove(entry2.getKey());
                            try {
                                entry2.getValue().recycle();
                            } catch (IllegalStateException unused3) {
                                TLog.d(this.a, "message recycle error");
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean i(Message message, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, message, j)) == null) {
            int i = this.k.get();
            if (i == 2) {
                synchronized (this.f) {
                    Message obtain = Message.obtain();
                    obtain.copyFrom(message);
                    if (j == 0) {
                        this.g.add(obtain);
                    } else {
                        synchronized (this.e) {
                            this.h.put(Long.valueOf(System.currentTimeMillis() + j), obtain);
                        }
                    }
                    this.f.notify();
                }
                return true;
            }
            TLog.d(this.a, String.format("[%s] sendMessageDelayed() failed. mThreadStatus = %s", this.b, m[i]));
            return false;
        }
        return invokeLJ.booleanValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TLog.h(this.a, this.b + " onstart, priority=" + this.c);
            this.d.onStart();
            long j = 0L;
            do {
                synchronized (this.f) {
                    try {
                        if (this.g.isEmpty()) {
                            this.f.wait(j);
                        }
                        LinkedList<Message> linkedList = this.g;
                        this.g = this.i;
                        this.i = linkedList;
                        synchronized (this.e) {
                            this.j.putAll(this.h);
                            this.h.clear();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                LinkedList<Message> linkedList2 = new LinkedList();
                synchronized (this.e) {
                    Iterator it = ((TreeMap) this.j.clone()).entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (((Long) entry.getKey()).longValue() <= currentTimeMillis) {
                                Message message = new Message();
                                message.copyFrom((Message) entry.getValue());
                                this.j.remove(entry.getKey());
                                try {
                                    ((Message) entry.getValue()).recycle();
                                } catch (IllegalStateException unused) {
                                    TLog.d(this.a, "message recycle error");
                                }
                                linkedList2.add(message);
                            } else {
                                j = ((Long) entry.getKey()).longValue() - currentTimeMillis;
                                break;
                            }
                        } else {
                            j = 0;
                            break;
                        }
                    }
                }
                for (Message message2 : linkedList2) {
                    this.d.handleMessage(message2);
                }
                while (true) {
                    Message poll = this.i.poll();
                    if (poll == null) {
                        break;
                    }
                    int i = poll.what;
                    if (i == -10003) {
                        this.k.set(3);
                        this.d.onPause();
                    } else if (i == -10004) {
                        this.d.onResume();
                    } else {
                        this.d.handleMessage(poll);
                    }
                    try {
                        poll.recycle();
                    } catch (IllegalStateException unused2) {
                        TLog.d(this.a, "message recycle error");
                    }
                }
            } while (this.k.get() != 4);
            TLog.d(this.a, this.b + " stopped");
            TLog.h(this.a, this.b + " onstop");
            this.d.onStop();
        }
    }
}
