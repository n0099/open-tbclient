package com.baidu.tieba.frs.forumRule.e;

import com.baidu.adp.lib.util.StringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes22.dex */
public class a {
    public static long Ld(String str) {
        if (StringUtils.isNull(str)) {
            return 0L;
        }
        try {
            Date parse = new SimpleDateFormat("yyyy.MM.dd").parse(str);
            return (parse != null ? parse.getTime() : 0L) / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static int gp(long j) {
        if (j < 0) {
            return -1;
        }
        return (int) (j / 86400);
    }
}
