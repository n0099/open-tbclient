package com.baidu.tieba;

import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes4.dex */
public interface gl0 {
    public static final ServiceReference a = new ServiceReference("nad.core", "downloadCreator");

    IAdDownloader a();
}
