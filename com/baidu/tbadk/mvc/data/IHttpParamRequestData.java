package com.baidu.tbadk.mvc.data;

import com.baidu.tieba.mn5;
import java.util.HashMap;
/* loaded from: classes5.dex */
public interface IHttpParamRequestData extends mn5 {
    HashMap<String, String> getHttpHeader();

    HashMap<String, Object> makeHttpParam();
}
