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
import tbclient.AlbumElement;
import tbclient.ItemGameCode;
import tbclient.ItemGameInfo;
import tbclient.ItemInfo;
import tbclient.ItemPage.DataRes;
import tbclient.RecentUpdate;
import tbclient.ThreadInfo;
/* loaded from: classes4.dex */
public class ho6 implements gb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<Cdo> c;
    public boolean d;

    public ho6() {
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
        this.c = new ArrayList<>();
    }

    public void a(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) || dataRes == null) {
            return;
        }
        ItemInfo itemInfo = dataRes.item_info;
        this.a = itemInfo;
        if (itemInfo == null) {
            return;
        }
        this.b = dataRes.album_list;
        int i = 1;
        this.d = dataRes.has_tornado.intValue() == 1;
        ItemGameCode itemGameCode = dataRes.item_game_code;
        if (itemGameCode != null && ListUtils.getCount(itemGameCode.game_code_list) != 0) {
            zo6 zo6Var = new zo6();
            zo6Var.h(dataRes.item_game_code);
            this.c.add(zo6Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                ap6 ap6Var = new ap6();
                ap6Var.f(dataRes.item_game_info.hot_videos);
                this.c.add(ap6Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !dj.isEmpty(recentUpdate.log)) {
                bp6 bp6Var = new bp6();
                bp6Var.f(dataRes.item_game_info.recent_update);
                this.c.add(bp6Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            xo6 xo6Var = new xo6();
            xo6Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(xo6Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    xo6 xo6Var2 = new xo6();
                    xo6Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(xo6Var2);
                }
            }
            xo6 xo6Var3 = new xo6();
            xo6Var3.f(this.a.id.intValue());
            xo6Var3.setPositionInFrsItemTab(i);
            xo6Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(xo6Var3);
        }
        yo6 yo6Var = new yo6();
        yo6Var.h(dataRes.item_info);
        if (yo6Var.f()) {
            this.c.add(yo6Var);
        }
        cp6 cp6Var = new cp6();
        cp6Var.f(dataRes.recommend_item);
        this.c.add(cp6Var);
    }

    @Override // com.baidu.tieba.gb5
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.gb5
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
