package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ab8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public int x;
    public int y;
    public String z;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 1567) {
                    if (hashCode != 1568) {
                        if (hashCode != 1570) {
                            if (hashCode != 1576) {
                                if (hashCode != 1599) {
                                    switch (hashCode) {
                                        case 49:
                                            if (str.equals("1")) {
                                                c = 0;
                                                break;
                                            }
                                            break;
                                        case 50:
                                            if (str.equals("2")) {
                                                c = 2;
                                                break;
                                            }
                                            break;
                                        case 51:
                                            if (str.equals("3")) {
                                                c = 4;
                                                break;
                                            }
                                            break;
                                        case 52:
                                            if (str.equals("4")) {
                                                c = 3;
                                                break;
                                            }
                                            break;
                                        default:
                                            switch (hashCode) {
                                                case 54:
                                                    if (str.equals("6")) {
                                                        c = 7;
                                                        break;
                                                    }
                                                    break;
                                                case 55:
                                                    if (str.equals("7")) {
                                                        c = 1;
                                                        break;
                                                    }
                                                    break;
                                                case 56:
                                                    if (str.equals("8")) {
                                                        c = '\b';
                                                        break;
                                                    }
                                                    break;
                                                case 57:
                                                    if (str.equals("9")) {
                                                        c = '\t';
                                                        break;
                                                    }
                                                    break;
                                            }
                                    }
                                } else if (str.equals("21")) {
                                    c = '\f';
                                }
                            } else if (str.equals("19")) {
                                c = '\n';
                            }
                        } else if (str.equals("13")) {
                            c = 11;
                        }
                    } else if (str.equals("11")) {
                        c = 6;
                    }
                } else if (str.equals("10")) {
                    c = 5;
                }
                switch (c) {
                    case 0:
                    case 1:
                        return "a002";
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        return "a006";
                    case 7:
                        return "a005";
                    case '\b':
                    case '\t':
                    case '\n':
                        return "a020";
                    case 11:
                        return "a023";
                    case '\f':
                        return "a088";
                    default:
                        return "";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    public ab8() {
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
        this.z = "index";
    }

    public StatisticItem a(StatisticItem statisticItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, statisticItem)) == null) {
            if (statisticItem != null) {
                if (!StringUtils.isNull(this.a)) {
                    statisticItem.param("obj_locate", this.a);
                    statisticItem.param("page_type", a.a(this.a));
                    if (this.a.equals("21")) {
                        statisticItem.param(TiebaStatic.Params.BHV_ID, TbSingleton.getInstance().getCurrentClickTime());
                    }
                    if (this.a.equals("13") && !StringUtils.isNull(this.i) && this.z.equals(this.i)) {
                        statisticItem.param(TiebaStatic.Params.BHV_ID, TbSingleton.getInstance().getCurrentClickTime());
                    }
                }
                if (!StringUtils.isNull(this.c)) {
                    statisticItem.param("tid", this.c);
                }
                if (!StringUtils.isNull(this.d)) {
                    statisticItem.param("fid", this.d);
                }
                if (!StringUtils.isNull(this.e)) {
                    statisticItem.param("uid", this.e);
                }
                if (!StringUtils.isNull(this.f)) {
                    statisticItem.param("obj_source", this.f);
                } else {
                    statisticItem.param("obj_source", 0);
                }
                if (!StringUtils.isNull(this.g)) {
                    statisticItem.param("obj_param1", this.g);
                } else {
                    statisticItem.param("obj_param1", 0);
                }
                if (!StringUtils.isNull(this.h)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.h);
                }
                if (!StringUtils.isNull(this.i)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, this.i);
                }
                int i = this.j;
                if (i > 0) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, i);
                }
                if (!StringUtils.isNull(this.k)) {
                    statisticItem.param("obj_id", this.k);
                }
                if (!StringUtils.isNull(this.l)) {
                    statisticItem.param("ab_tag", this.l);
                } else {
                    statisticItem.param("ab_tag", 0);
                }
                if (!StringUtils.isNull(this.n)) {
                    statisticItem.param(TiebaStatic.Params.TOPIC_TYPE, this.n);
                }
                if (!StringUtils.isNull(this.o)) {
                    statisticItem.param("extra", this.o);
                } else {
                    statisticItem.param("extra", 0);
                }
                if (!StringUtils.isNull(this.p)) {
                    statisticItem.param(TiebaStatic.Params.IS_VERTICAL, this.p);
                }
                if (!StringUtils.isNull(this.q)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, this.q);
                }
                if (!StringUtils.isNull(this.r)) {
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, this.r);
                }
                if (!StringUtils.isNull(this.s)) {
                    statisticItem.param("group_id", this.s);
                }
                int i2 = this.x;
                if (i2 > 0) {
                    statisticItem.param("request_num", i2);
                }
                int i3 = this.y;
                if (i3 > 0) {
                    statisticItem.param("video_num", i3);
                }
                statisticItem.param("obj_extra", StringUtils.isNull(this.w) ? "" : this.w);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, StringUtils.isNull(this.t) ? "" : this.t);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, StringUtils.isNull(this.u) ? "" : this.u);
                statisticItem.param("nid", StringUtils.isNull(this.v) ? "" : this.v);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public ab8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ab8 ab8Var = new ab8();
            ab8Var.a = this.a;
            ab8Var.b = this.b;
            ab8Var.c = this.c;
            ab8Var.d = this.d;
            ab8Var.e = this.e;
            ab8Var.f = this.f;
            ab8Var.g = this.g;
            ab8Var.h = this.h;
            ab8Var.i = this.i;
            ab8Var.k = this.k;
            ab8Var.l = this.l;
            ab8Var.m = this.m;
            ab8Var.n = this.n;
            ab8Var.q = this.q;
            ab8Var.r = this.r;
            ab8Var.s = this.s;
            ab8Var.t = this.t;
            ab8Var.u = this.u;
            ab8Var.v = this.v;
            ab8Var.x = this.x;
            ab8Var.y = this.y;
            return ab8Var;
        }
        return (ab8) invokeV.objValue;
    }
}
