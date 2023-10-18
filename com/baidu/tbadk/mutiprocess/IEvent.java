package com.baidu.tbadk.mutiprocess;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes5.dex */
public interface IEvent {
    public static final int TYPE_PROCESS_ALL = 0;
    public static final int TYPE_PROCESS_MAIN = 3;
    public static final int TYPE_PROCESS_OHTER = 1;
    public static final int TYPE_PROCESS_SELF = 2;

    int getPid();

    int getTag();

    int getType();

    void setTag(BdUniqueId bdUniqueId);
}
