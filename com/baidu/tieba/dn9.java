package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.BookInfo;
import tbclient.TbBookrack;
/* loaded from: classes5.dex */
public class dn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public List<en9> c;
    public String d;
    public String e;
    public String f;

    public dn9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbBookrack) != null) || tbBookrack == null) {
            return;
        }
        this.a = tbBookrack.booktown;
        this.b = tbBookrack.num.intValue();
        this.d = tbBookrack.title;
        this.e = tbBookrack.icon;
        this.f = tbBookrack.tip;
        this.c = new ArrayList();
        List<BookInfo> list = tbBookrack.book_list;
        if (list != null) {
            for (BookInfo bookInfo : list) {
                if (bookInfo != null) {
                    en9 en9Var = new en9();
                    en9Var.a(bookInfo);
                    this.c.add(en9Var);
                }
            }
        }
    }
}
