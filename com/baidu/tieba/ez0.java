package com.baidu.tieba;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ez0 implements Cursor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Cursor a;

    public ez0(Cursor cursor) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cursor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cursor;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (this.a != null) {
                    this.a.close();
                }
            } catch (Exception unused) {
                this.a = null;
            }
        }
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, charArrayBuffer) == null) {
            try {
                if (this.a != null) {
                    this.a.copyStringToBuffer(i, charArrayBuffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
        }
    }

    @Override // android.database.Cursor
    public void deactivate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.a != null) {
                    this.a.deactivate();
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
        }
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getBlob(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
            return null;
        }
        return (byte[]) invokeI.objValue;
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getColumnCount();
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getColumnIndex(str);
                }
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getColumnIndexOrThrow(str);
                }
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return -1;
            }
        }
        return invokeL.intValue;
    }

    @Override // android.database.Cursor
    public String getColumnName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getColumnName(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getColumnNames();
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
            return null;
        }
        return (String[]) invokeV.objValue;
    }

    @Override // android.database.Cursor
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getCount();
                }
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return -1;
            }
        }
        return invokeV.intValue;
    }

    @Override // android.database.Cursor
    public double getDouble(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getDouble(i);
                }
                return 0.0d;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return 0.0d;
            }
        }
        return invokeI.doubleValue;
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getExtras();
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
            return null;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // android.database.Cursor
    public float getFloat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getFloat(i);
                }
                return 0.0f;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return 0.0f;
            }
        }
        return invokeI.floatValue;
    }

    @Override // android.database.Cursor
    public int getInt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getInt(i);
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return 0;
            }
        }
        return invokeI.intValue;
    }

    @Override // android.database.Cursor
    public long getLong(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getLong(i);
                }
                return 0L;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return 0L;
            }
        }
        return invokeI.longValue;
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getNotificationUri();
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
            return null;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // android.database.Cursor
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getPosition();
                }
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return -1;
            }
        }
        return invokeV.intValue;
    }

    @Override // android.database.Cursor
    public short getShort(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getShort(i);
                }
                return (short) 0;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return (short) 0;
            }
        }
        return invokeI.shortValue;
    }

    @Override // android.database.Cursor
    public String getString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getString(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // android.database.Cursor
    public int getType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getType(i);
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return 0;
            }
        }
        return invokeI.intValue;
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.getWantsAllOnMoveCalls();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.isAfterLast();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.isBeforeFirst();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.isClosed();
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.isFirst();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.isLast();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isNull(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.isNull(i);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean move(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.move(i);
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.moveToFirst();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.moveToLast();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.moveToNext();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            try {
                if (this.a != null) {
                    return this.a.moveToPosition(i);
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.moveToPrevious();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, contentObserver) == null) {
            try {
                if (this.a != null) {
                    this.a.registerContentObserver(contentObserver);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
        }
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, dataSetObserver) == null) {
            try {
                if (this.a != null) {
                    this.a.registerDataSetObserver(dataSetObserver);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
        }
    }

    @Override // android.database.Cursor
    public boolean requery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            try {
                if (this.a != null) {
                    return this.a.requery();
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bundle)) == null) {
            try {
                if (this.a != null) {
                    return this.a.respond(bundle);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            try {
                if (this.a == null || Build.VERSION.SDK_INT < 23) {
                    return;
                }
                this.a.setExtras(bundle);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
        }
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, contentResolver, uri) == null) {
            try {
                if (this.a != null) {
                    this.a.setNotificationUri(contentResolver, uri);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
        }
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, contentObserver) == null) {
            try {
                if (this.a != null) {
                    this.a.unregisterContentObserver(contentObserver);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
        }
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, dataSetObserver) == null) {
            try {
                if (this.a != null) {
                    this.a.unregisterDataSetObserver(dataSetObserver);
                }
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    if (this.a != null) {
                        this.a.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.a = null;
            }
        }
    }
}
