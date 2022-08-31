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
/* loaded from: classes3.dex */
public class bn6 implements y85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ItemInfo a;
    public List<AlbumElement> b;
    public ArrayList<pn> c;
    public boolean d;

    public bn6() {
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
            tn6 tn6Var = new tn6();
            tn6Var.h(dataRes.item_game_code);
            this.c.add(tn6Var);
        }
        ItemGameInfo itemGameInfo = dataRes.item_game_info;
        if (itemGameInfo != null) {
            List<ThreadInfo> list = itemGameInfo.hot_videos;
            if (list != null && ListUtils.getCount(list) >= 3) {
                un6 un6Var = new un6();
                un6Var.f(dataRes.item_game_info.hot_videos);
                this.c.add(un6Var);
            }
            RecentUpdate recentUpdate = dataRes.item_game_info.recent_update;
            if (recentUpdate != null && !qi.isEmpty(recentUpdate.log)) {
                vn6 vn6Var = new vn6();
                vn6Var.f(dataRes.item_game_info.recent_update);
                this.c.add(vn6Var);
            }
        }
        if (!ListUtils.isEmpty(dataRes.thread_list)) {
            rn6 rn6Var = new rn6();
            rn6Var.setSupportType(BaseCardInfo.SupportType.TOP);
            this.c.add(rn6Var);
            for (ThreadInfo threadInfo : dataRes.thread_list) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.setPositionInFrsItemTab(i);
                    i++;
                    threadData.insertItemToTitleOrAbstractText();
                    this.c.add(threadData);
                    rn6 rn6Var2 = new rn6();
                    rn6Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                    this.c.add(rn6Var2);
                }
            }
            rn6 rn6Var3 = new rn6();
            rn6Var3.f(this.a.id.intValue());
            rn6Var3.setPositionInFrsItemTab(i);
            rn6Var3.setSupportType(BaseCardInfo.SupportType.BOTTOM);
            this.c.add(rn6Var3);
        }
        sn6 sn6Var = new sn6();
        sn6Var.h(dataRes.item_info);
        if (sn6Var.f()) {
            this.c.add(sn6Var);
        }
        wn6 wn6Var = new wn6();
        wn6Var.f(dataRes.recommend_item);
        this.c.add(wn6Var);
    }

    @Override // com.baidu.tieba.y85
    public void initByJson(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.baidu.tieba.y85
    public void initByProtobuf(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, message) == null) {
        }
    }
}
