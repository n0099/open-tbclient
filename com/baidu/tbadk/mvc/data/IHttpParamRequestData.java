package com.baidu.tbadk.mvc.data;

import com.baidu.tieba.nr5;
import java.util.HashMap;
/* loaded from: classes4.dex */
public interface IHttpParamRequestData extends nr5 {
    HashMap<String, String> getHttpHeader();

    HashMap<String, Object> makeHttpParam();
}
