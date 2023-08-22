package com.baidu.tbadk.mvc.data;

import com.baidu.tieba.tq5;
import java.util.HashMap;
/* loaded from: classes4.dex */
public interface IHttpParamRequestData extends tq5 {
    HashMap<String, String> getHttpHeader();

    HashMap<String, Object> makeHttpParam();
}
