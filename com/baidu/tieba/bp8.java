package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.util.PriorityOrganizer;
/* loaded from: classes3.dex */
public interface bp8 {

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: com.baidu.tieba.bp8$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public interface InterfaceC0213a {
            void a(@NonNull s35 s35Var);

            boolean b();
        }

        void a(@Nullable InterfaceC0213a interfaceC0213a);
    }

    @NonNull
    PriorityOrganizer d0();

    int getCurrentTabType();

    @NonNull
    a q0();
}
