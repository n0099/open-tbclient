package com.baidu.tieba.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class Hao123Data implements Serializable {
    private static final long serialVersionUID = 1;
    public String login = "";
    public String more = "";
    public List<BarInfo> myBa = new ArrayList();

    /* loaded from: classes.dex */
    public class BarInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public String baName = "";
        public String qianDao = "";
        public String level = "";
        public String baID = "";
    }
}
