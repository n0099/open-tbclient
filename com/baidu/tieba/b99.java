package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
/* loaded from: classes3.dex */
public class b99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i99 a;
    public HashSet<String> b;
    public HashSet<String> c;
    public HashSet<String> d;
    public HashSet<String> e;
    public HashSet<String> f;
    public HashSet<String> g;
    public HashMap<String, Integer> h;
    public HashMap<String, String> i;
    public HashMap<String, h99> j;
    public HashSet<String> k;
    public HashSet<String> l;
    public HashMap<String, Integer> m;
    public HashMap<String, Integer> n;
    public HashMap<String, Integer> o;

    public b99() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new i99();
        this.b = new HashSet<>();
        this.c = new HashSet<>();
        this.d = new HashSet<>();
        this.e = new HashSet<>();
        this.f = new HashSet<>();
        this.g = new HashSet<>();
        this.h = new HashMap<>();
        this.i = new HashMap<>();
        this.j = new HashMap<>();
        this.k = new HashSet<>();
        this.l = new HashSet<>();
        this.m = new HashMap<>();
        this.n = new HashMap<>();
        this.o = new HashMap<>();
    }
}
