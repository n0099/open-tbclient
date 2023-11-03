package com.baidu.tbadk.mvc.data;

import com.baidu.tieba.ln5;
import java.util.HashMap;
/* loaded from: classes5.dex */
public interface IHttpParamRequestData extends ln5 {
    HashMap<String, String> getHttpHeader();

    HashMap<String, Object> makeHttpParam();
}
