package com.baidu.tbadk.mvc.data;

import com.baidu.tieba.or5;
import java.util.HashMap;
/* loaded from: classes4.dex */
public interface IHttpParamRequestData extends or5 {
    HashMap<String, String> getHttpHeader();

    HashMap<String, Object> makeHttpParam();
}
