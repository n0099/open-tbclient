package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ItemGameCode;
import tbclient.ItemGameInfo;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.RecentUpdate;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class cp6 implements yb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List b;
    public ArrayList c;
    public boolean d;

    @Override // com.baidu.tieba.yb5
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.yb5
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }

    public cp6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
    }

    public void a(DataRes dataRes) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.a = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.b = dataRes.album_list;
        int i = 1;
        if (dataRes.has_tornado.intValue() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.d = z;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            up6 up6Var = new up6();
            up6Var.h(dataRes.item_game_code);
            this.c.add(up6Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                vp6 vp6Var = new vp6();
                vp6Var.f(dataRes.item_game_info.hot_videos);
                this.c.add(vp6Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !ej.isEmpty(recentUpdate.log)) {
                wp6 wp6Var = new wp6();
                wp6Var.f(dataRes.item_game_info.recent_update);
                this.c.add(wp6Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            sp6 sp6Var = new sp6();
            sp6Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(sp6Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    sp6 sp6Var2 = new sp6();
                    sp6Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(sp6Var2);
                }
            }
            sp6 sp6Var3 = new sp6();
            sp6Var3.f(this.a.id.intValue());
            sp6Var3.setPositionInFrsItemTab(i);
            sp6Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(sp6Var3);
        }
        tp6 tp6Var = new tp6();
        tp6Var.h(dataRes.item_info);
        if (tp6Var.f()) {
            this.c.add(tp6Var);
        }
        xp6 xp6Var = new xp6();
        xp6Var.f(dataRes.recommend_item);
        this.c.add(xp6Var);
    }
}
