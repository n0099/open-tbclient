package com.baidu.tbadk.mvc.data;

import com.baidu.tieba.ul5;
import java.util.HashMap;
/* loaded from: classes5.dex */
public interface IHttpParamRequestData extends ul5 {
    HashMap<String, String> getHttpHeader();

    HashMap<String, Object> makeHttpParam();
}
