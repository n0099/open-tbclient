package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.switchs.VideoMiddleAdSwitch;
import com.baidu.tieba.video.LiveConfig;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.data.VideoAttentionPersonListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class g8b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public final List<VideoItemModel> b;
    public final List<VideoAttentionPersonListData> c;
    public String d;
    public final int e;
    public final int f;
    public String g;
    public int h;
    public boolean i;
    public f8b j;
    public LiveConfig k;

    public g8b() {
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
        this.h = -1;
        this.i = true;
        this.b = new LinkedList();
        this.e = b85.m() - 1;
        this.f = b85.l() + 1;
        this.c = new LinkedList();
    }

    @Nullable
    public Long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int size = this.b.size();
            while (true) {
                size--;
                if (size < 0) {
                    return null;
                }
                VideoItemData u = u(size);
                if (u != null) {
                    long j = JavaTypesHelper.toLong(u.getThreadId(), 0L);
                    if (j == 0) {
                        return null;
                    }
                    return Long.valueOf(j);
                }
            }
        } else {
            return (Long) invokeV.objValue;
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.b.size() != 0 && (this.b.size() != 1 || !this.b.get(0).isLoadingType())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void A(List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
            return;
        }
        this.h = -1;
        List arrayList = new ArrayList(this.b);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= arrayList.size()) {
                break;
            }
            if (((VideoItemModel) ListUtils.getItem(arrayList, i)).isFunAdType()) {
                this.h = i;
            } else {
                int i3 = i2 + 1;
                VideoItemData videoItemData = (VideoItemData) ListUtils.getItem(list, i2);
                if (videoItemData == null) {
                    arrayList = arrayList.subList(0, i);
                    i2 = i3;
                    break;
                }
                arrayList.set(i, new VideoItemModel(videoItemData, 1));
                i2 = i3;
            }
            i++;
        }
        if (i2 < list.size()) {
            for (VideoItemData videoItemData2 : list.subList(i2, list.size())) {
                arrayList.add(new VideoItemModel(videoItemData2, 1));
            }
        }
        this.b.clear();
        this.b.addAll(arrayList);
        d();
        this.i = true;
        f8b f8bVar = this.j;
        if (f8bVar != null) {
            f8bVar.b();
        }
    }

    public void a(int i) {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || !VideoMiddleAdSwitch.isOnAndHitVideoAdDrawTest() || !this.i) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.b);
        if (this.h < 0) {
            int i2 = this.e;
            this.h = i2;
            if (i2 <= i) {
                return;
            }
            if (i2 >= arrayList.size() + 1) {
                this.h = -1;
                return;
            }
            VideoItemModel videoItemModel2 = (VideoItemModel) ListUtils.getItem(arrayList, this.h);
            if (videoItemModel2 == null || !videoItemModel2.isFunAdType()) {
                arrayList.add(this.h, new VideoItemModel(null, 2));
            }
        }
        int i3 = this.h;
        while (true) {
            i3 += this.f;
            if (i3 >= arrayList.size() + 1) {
                break;
            } else if (i3 > i && ((videoItemModel = (VideoItemModel) ListUtils.getItem(arrayList, i3)) == null || !videoItemModel.isFunAdType())) {
                this.h = i3;
                arrayList.add(i3, new VideoItemModel(null, 2));
            }
        }
        this.b.clear();
        this.b.addAll(arrayList);
        f8b f8bVar = this.j;
        if (f8bVar != null) {
            f8bVar.f();
        }
    }

    public void B(List<VideoAttentionPersonListData> list, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str) == null) {
            this.b.clear();
            this.b.add(new VideoItemModel(null, 4));
            this.c.clear();
            this.c.addAll(list);
            this.d = str;
            this.i = false;
        }
    }

    public void C(LiveConfig liveConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, liveConfig) == null) {
            this.k = liveConfig;
        }
    }

    public void E(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            this.a = bdUniqueId;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.g = str;
        }
    }

    public void G(f8b f8bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, f8bVar) == null) {
            this.j = f8bVar;
        }
    }

    @Nullable
    public UserItemData i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            VideoItemData u = u(i);
            if (u != null) {
                return u.author_info;
            }
            return null;
        }
        return (UserItemData) invokeI.objValue;
    }

    public VideoItemModel n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            return (VideoItemModel) ListUtils.getItem(this.b, i);
        }
        return (VideoItemModel) invokeI.objValue;
    }

    @Nullable
    public String s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            VideoItemData u = u(i);
            if (u != null) {
                return u.getThreadId();
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Nullable
    public VideoItemData t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.b, i);
            if (videoItemModel == null) {
                return null;
            }
            return videoItemModel.getVideoItemData();
        }
        return (VideoItemData) invokeI.objValue;
    }

    @Nullable
    public final VideoItemData u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            return this.b.get(i).getVideoItemData();
        }
        return (VideoItemData) invokeI.objValue;
    }

    public boolean z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            int i2 = this.e;
            while (i2 < this.b.size()) {
                if (i2 == i) {
                    return true;
                }
                i2 += this.f;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.clear();
            this.b.add(new VideoItemModel(null, 3));
            this.i = false;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.b.size() == 0) {
            this.b.add(new VideoItemModel(null, VideoItemModel.TYPE_LOADING));
        }
    }

    public final void d() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.b.size() > 1 && (videoItemModel = this.b.get(0)) != null && videoItemModel.isLoadingType()) {
            this.b.remove(0);
        }
    }

    public List<VideoItemModel> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public List<VideoItemModel> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public LiveConfig m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.k;
        }
        return (LiveConfig) invokeV.objValue;
    }

    public BdUniqueId o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public List<VideoAttentionPersonListData> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return ListUtils.isEmpty(this.b);
        }
        return invokeV.booleanValue;
    }

    public synchronized void b(@NonNull List<VideoItemData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (VideoItemData videoItemData : list) {
                    if (this.b.size() == 0 || x(videoItemData)) {
                        arrayList.add(new VideoItemModel(videoItemData, 1));
                    }
                }
                if (!ListUtils.isEmpty(arrayList)) {
                    this.b.addAll(arrayList);
                }
                if (this.j != null) {
                    this.j.f();
                }
            }
        }
    }

    public boolean e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (i < 0) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoItemModel next = it.next();
                if (next.getHashCode() == i) {
                    videoItemModel = next;
                    break;
                }
            }
            if (videoItemModel == null || !videoItemModel.isFunAdType()) {
                return false;
            }
            int indexOf = this.b.indexOf(videoItemModel);
            int i2 = this.h;
            if (indexOf < i2) {
                this.h = i2 - 1;
            }
            this.b.remove(videoItemModel);
            f8b f8bVar = this.j;
            if (f8bVar != null) {
                f8bVar.e();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            VideoItemModel videoItemModel = null;
            Iterator<VideoItemModel> it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VideoItemModel next = it.next();
                if (next != null && next.getVideoItemData() != null && str.equalsIgnoreCase(next.getVideoItemData().thread_id)) {
                    videoItemModel = next;
                    break;
                }
            }
            if (videoItemModel == null) {
                return false;
            }
            this.b.remove(videoItemModel);
            f8b f8bVar = this.j;
            if (f8bVar != null) {
                f8bVar.e();
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            for (int i2 = i + 1; i2 < this.b.size(); i2++) {
                VideoItemModel videoItemModel = (VideoItemModel) ListUtils.getItem(this.b, i2);
                if (videoItemModel != null && videoItemModel.isFunAdType()) {
                    this.b.remove(videoItemModel);
                    return true;
                }
            }
            if (this.h + this.f > this.b.size() - 1) {
                this.h += this.f;
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final boolean x(VideoItemData videoItemData) {
        InterceptResult invokeL;
        VideoItemData videoItemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, videoItemData)) == null) {
            if (videoItemData == null || videoItemData.getThreadId() == null) {
                return false;
            }
            if (this.b.size() < 1) {
                return true;
            }
            int i = 0;
            for (int size = this.b.size() - 1; size >= 0 && i < 30; size--) {
                VideoItemModel videoItemModel = this.b.get(size);
                if (videoItemModel != null && (videoItemData2 = videoItemModel.getVideoItemData()) != null && videoItemData2.getThreadId() != null) {
                    if (videoItemData2.getThreadId().equals(videoItemData.getThreadId())) {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean v(VideoItemModel videoItemModel, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, videoItemModel, i)) == null) {
            if (i == 0 && this.b.size() > 0 && this.b.get(0).isLoadingType()) {
                this.b.set(0, videoItemModel);
                f8b f8bVar = this.j;
                if (f8bVar != null) {
                    f8bVar.f();
                }
                return true;
            }
            if (i < this.b.size()) {
                this.b.add(i, videoItemModel);
            } else {
                this.b.add(videoItemModel);
            }
            d();
            f8b f8bVar2 = this.j;
            if (f8bVar2 != null) {
                f8bVar2.f();
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
